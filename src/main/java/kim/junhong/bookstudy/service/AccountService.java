package kim.junhong.bookstudy.service;

import kim.junhong.bookstudy.dto.SignUpRequest;
import kim.junhong.bookstudy.model.Account;
import kim.junhong.bookstudy.model.AccountType;
import kim.junhong.bookstudy.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public Account signUpWithEmail(SignUpRequest dto) {
        Account newAccount = Account.builder()
                .accountType(AccountType.EMAIL)
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .email(dto.getUsername())
                .build();
        return accountRepository.save(newAccount);
    }
}
