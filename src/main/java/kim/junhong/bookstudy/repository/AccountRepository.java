package kim.junhong.bookstudy.repository;

import kim.junhong.bookstudy.model.Account;
import kim.junhong.bookstudy.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsernameAndStatus(String username, Status status);
}
