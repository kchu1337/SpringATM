package Atm;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ATMRepository extends CrudRepository<Transaction, Integer>  {

    /*@Query("order by accid")
    public List<Transaction> findAllOrderbyaccid();*/

    public List<Transaction> findAllByAccID(String id);

    @Query(value = "Select Sum(amt) From transaction where accid = :accid", nativeQuery = true)
    public double sumByAccID(@Param("accid") String id);
}
