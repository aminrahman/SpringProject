package aminrahman.dotin.springproject.repository;

import aminrahman.dotin.springproject.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
@Transactional
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Date> {

}
