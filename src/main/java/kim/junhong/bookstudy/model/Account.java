package kim.junhong.bookstudy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private String username;
    private String password;
    private String email;
    private String accessToken;
    private String refreshToken;
}
