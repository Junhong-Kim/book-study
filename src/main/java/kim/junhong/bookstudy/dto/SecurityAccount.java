package kim.junhong.bookstudy.dto;

import kim.junhong.bookstudy.model.Account;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityAccount extends User {

    public SecurityAccount(Account account) {
        super(account.getUsername(), account.getPassword(), AuthorityUtils.createAuthorityList("USER"));
    }
}
