package aminrahman.dotin.springproject.repository;

import aminrahman.dotin.springproject.entity.Printer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrinterRepository extends JpaRepository<Printer, String> {
}
