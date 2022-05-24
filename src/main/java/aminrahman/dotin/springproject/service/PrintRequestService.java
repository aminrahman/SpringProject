package aminrahman.dotin.springproject.service;

import aminrahman.dotin.springproject.exception.RecordAlreadyExistsException;
import aminrahman.dotin.springproject.entity.PrintPK;
import aminrahman.dotin.springproject.entity.PrintRequest;
import aminrahman.dotin.springproject.repository.PrintRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PrintRequestService {
    private final PrintRequestRepository printRequestRepository;
    private final Logger logger = LoggerFactory.getLogger(PrintRequestService.class);

    public PrintRequestService(@Autowired PrintRequestRepository printRequestRepository) {
        this.printRequestRepository = printRequestRepository;
    }

    public PrintRequest getPrintRequestById(PrintPK printPK) {
        Optional<PrintRequest> printRequestOptional = printRequestRepository.findById(printPK);
        printRequestOptional.ifPresent(printRequest -> logger.info(printRequest.getCardPAN()));
        return printRequestOptional.get();
    }

    public PrintRequest findPrintRequestByCardPAN(String cardPAN) {
        return printRequestRepository.findPrintRequestByCardPAN(cardPAN);
    }

    public void findIpAddresses(String branchCode) {
        printRequestRepository.findPrintRequestIpAddressesByPrintIdBranchCode(branchCode).forEach(ipAddress -> logger.info("Ip address:" + ipAddress));
    }

    public PrintRequest saveRecord(PrintRequest printRequest) {
        printRequestRepository.findById(printRequest.getPrintId()).ifPresent(printRequest1 -> {
            throw new RecordAlreadyExistsException(
                    "Record with Ip Address: "
                    + printRequest.getPrintId().getIpAddress() + " And Branch Code: " + printRequest.getPrintId().getBranchCode() + " already exists.");
        });
        PrintRequest savedPrintRequest = printRequestRepository.save(printRequest);
        logger.info("Saved record and personnel code is: " + savedPrintRequest.getPersonnelCode());
        return savedPrintRequest;
    }

    public Iterable<PrintRequest> getAll() {
        logger.info("Getting all PrintRequests");
        return printRequestRepository.findAll();
    }


    //A method which is NOT Transactional.
    public void updateCardPanNonTransactional(PrintPK printId, String newCardPan) {
        Optional<PrintRequest> printRequestOptional1 = printRequestRepository.findById(printId);
        printRequestOptional1.ifPresent(printRequest -> {
            logger.info("Old card pan of the loaded PrintRequest: " + printRequest.getCardPAN());
            printRequest.setCardPAN(newCardPan);
            logger.info("New card pan is set on loaded PrintRequest and it is: " + printRequest.getCardPAN());
        });

        Optional<PrintRequest> printRequestOptional2 = printRequestRepository.findById(printId);
        printRequestOptional2.ifPresent(printRequest -> logger.info("Since method is not transactional," +
                " card pan is not updated on persistence level. card pan: " + printRequest.getCardPAN()));
    }

    //A method which IS Transactional.
    @Transactional
    public void updateCardPanTransactional(PrintPK printId, String newCardPan) {
        Optional<PrintRequest> printRequestOptional1 = printRequestRepository.findById(printId);
        printRequestOptional1.ifPresent(printRequest -> {
            logger.info("Old card pan of the loaded PrintRequest: " + printRequest.getCardPAN());
            printRequest.setCardPAN(newCardPan);
            logger.info("New card pan is set on loaded PrintRequest and it is: " + printRequest.getCardPAN());
        });

        Optional<PrintRequest> printRequestOptional2 = printRequestRepository.findById(printId);
        printRequestOptional2.ifPresent(printRequest -> logger.info("Since method is transactional," +
                " card pan is updated on persistence level. card pan: " + printRequest.getCardPAN()));

    }

    @Transactional
    public PrintRequest patch(PrintRequest printRequestToPatch) {
        PrintRequest loadedPrintRequest = printRequestRepository.findById(printRequestToPatch.getPrintId()).get();
        loadedPrintRequest.setPersonnelCode(printRequestToPatch.getPersonnelCode());
        loadedPrintRequest.setCardPAN(printRequestToPatch.getCardPAN());
        return loadedPrintRequest;
    }

    @Transactional
    public PrintRequest update(PrintRequest printRequestToUpdate) {
        try {
            PrintRequest loadedPrintRequest = printRequestRepository.findById(printRequestToUpdate.getPrintId()).get();
            loadedPrintRequest.setPersonnelCode(printRequestToUpdate.getPersonnelCode());
            loadedPrintRequest.setCardPAN(printRequestToUpdate.getCardPAN());
            return loadedPrintRequest;
        } catch (Throwable e) {
            e.printStackTrace();
            return printRequestRepository.save(printRequestToUpdate);
        }
    }
}
