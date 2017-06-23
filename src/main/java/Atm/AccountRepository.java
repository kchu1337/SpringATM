package Atm;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by student on 6/23/17.
 */
public interface AccountRepository extends CrudRepository<Account, String> {

    @Query(value = "Select name from account where account = :accid",nativeQuery = true)
    public String findNameByAccount(@Param("accid") String acc);
}
