package Atm;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ATMRepository extends CrudRepository<Transaction, Integer>  {

    /*@Query("order by accid")
    public List<Transaction> findAllOrderbyaccid();*/
}