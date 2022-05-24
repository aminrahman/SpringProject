package aminrahman.dotin.springproject.aspect;

import aminrahman.dotin.springproject.entity.ActivityLog;
import aminrahman.dotin.springproject.entity.PrintRequest;
import aminrahman.dotin.springproject.service.ActivityLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Value("${application.type}")
    private Integer applicationType;

    private final ActivityLogService service;

    public LoggingAspect(@Autowired ActivityLogService service) {
        this.service = service;
    }

    @AfterReturning(value = "execution(* aminrahman.dotin.springproject.controller.*.*(..))", returning = "result")
    public void logAfterOperation(JoinPoint joinPoint, Object result) {

        logger.debug("Logging operation: " + joinPoint.getSignature());

        ResponseEntity responseEntity = (ResponseEntity) result;
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            ActivityLog activityLog;
            if (responseEntity.getBody() instanceof PrintRequest) {
                PrintRequest printRequest = (PrintRequest) responseEntity.getBody();
                activityLog = ActivityLog.builder()
                        .applicationType(applicationType)
                        .issueOperationName(joinPoint.getSignature().getName())
                        .panNumber(printRequest.getCardPAN())
                        .personnelCode(printRequest.getPersonnelCode())
                        .issueDate(new Timestamp(System.currentTimeMillis()))
                        .build();
                service.save(activityLog);
            } else if (responseEntity.getBody() instanceof List) {
                List<PrintRequest> printRequests = (List<PrintRequest>) responseEntity.getBody();
                if (printRequests != null && !printRequests.isEmpty()) {
                    activityLog = ActivityLog.builder()
                            .applicationType(applicationType)
                            .issueOperationName(joinPoint.getSignature().getName())
                            .panNumber(printRequests.get(0).getCardPAN())
                            .personnelCode(printRequests.get(0).getPersonnelCode())
                            .issueDate(new Timestamp(System.currentTimeMillis()))
                            .build();
                    service.save(activityLog);
                }
            }
        }
    }
}
