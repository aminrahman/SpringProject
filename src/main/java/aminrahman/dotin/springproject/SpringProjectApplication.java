package aminrahman.dotin.springproject;

import aminrahman.dotin.springproject.entity.PrintPK;
import aminrahman.dotin.springproject.entity.PrintRequest;
import aminrahman.dotin.springproject.service.PrintRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringProjectApplication.class, args);
        Logger logger = LoggerFactory.getLogger(SpringProjectApplication.class);
        PrintRequestService printRequestService = applicationContext.getBean(PrintRequestService.class);


        logger.info("Finding PrintRequest using default method findById:");
        PrintPK printPK = PrintPK.builder().ipAddress("10.20.12.35").branchCode("255").build();
        logger.info("Ip Address: " + printRequestService.getPrintRequestById(printPK).getPrintId().getIpAddress());

        logger.info("Finding PrintRequest using custom interface method with SQL tag findPrintRequestByCardPAN:");
        logger.info("Ip Address: " + printRequestService.findPrintRequestByCardPAN("1234567891123456").getPrintId().ipAddress);

        logger.info("Finding All Ip Addresses with a specific Branch Code:");
        printRequestService.findIpAddresses("255");

        logger.info("Saving a new record.");
        printRequestService.saveRecord(PrintRequest.builder().printId(PrintPK.builder().ipAddress("150.160.12.13").branchCode("3322").build()).personnelCode("24524").cardPAN("6104337437771234").build());

        logger.info("Testing non-transactional service method>>>>>>>>>>>>>>>");
        printRequestService.updateCardPanNonTransactional(PrintPK.builder().ipAddress("150.160.12.13").branchCode("3322").build(), "5859832098765432");

        logger.info("Testing transactional service method>>>>>>>>>>>>>>>");
        printRequestService.updateCardPanTransactional(PrintPK.builder().ipAddress("150.160.12.13").branchCode("3322").build(), "5859832098765432");
    }

}
