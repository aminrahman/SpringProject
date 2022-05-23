package aminrahman.dotin.springproject.repository;

import aminrahman.dotin.springproject.entity.PrintPK;
import aminrahman.dotin.springproject.entity.PrintRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PrintRequestRepository extends PagingAndSortingRepository<PrintRequest, PrintPK> {

    @Query("select p from PrintRequest p where p.cardPAN = :cardPan")//With Query
    PrintRequest findPrintRequestByCardPAN(@Param("cardPan") String cardPan);

    @Query("select p.printId.ipAddress from PrintRequest p where p.printId.branchCode = :branchCode")//With Query to find ip addresses by branch code.
    List<String> findPrintRequestIpAddressesByPrintIdBranchCode(@Param("branchCode")String branchCode);



    //Name based methods are usable from extending PagingAndSortingRepository
}

