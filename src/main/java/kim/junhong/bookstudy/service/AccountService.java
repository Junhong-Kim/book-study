package kim.junhong.bookstudy.service;

import kim.junhong.bookstudy.dto.SecurityAccount;
import kim.junhong.bookstudy.model.Account;
import kim.junhong.bookstudy.model.Status;
import kim.junhong.bookstudy.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findByUsernameAndStatus(username, Status.VALID);
        Account account = optionalAccount.orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 사용자입니다."));
        return new SecurityAccount(account);
    }
}
