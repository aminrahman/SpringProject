package aminrahman.dotin.springproject.service;

import aminrahman.dotin.springproject.entity.ActivityLog;
import aminrahman.dotin.springproject.repository.ActivityLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogService {

    private final Logger logger = LoggerFactory.getLogger(ActivityLogService.class);
    private final ActivityLogRepository repository;

    public ActivityLogService(@Autowired ActivityLogRepository repository) {
        this.repository = repository;
    }

    public void save(ActivityLog activityLog) {
        logger.info("Saving activity log on date: " + activityLog.getIssueDate());
        repository.save(activityLog);
    }
}
