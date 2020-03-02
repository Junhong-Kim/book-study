package kim.junhong.bookstudy.controller;

import kim.junhong.bookstudy.dto.AuthRequest;
import kim.junhong.bookstudy.dto.AuthResponse;
import kim.junhong.bookstudy.dto.SignUpRequest;
import kim.junhong.bookstudy.dto.SignUpResponse;
import kim.junhong.bookstudy.model.Account;
import kim.junhong.bookstudy.service.AccountService;
import kim.junhong.bookstudy.service.CustomUserDetailsService;
import kim.junhong.bookstudy.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;
    private final AccountService accountService;

    @PostMapping("/signIn/email")
    public AuthResponse signInWithEmail(@RequestBody AuthRequest authRequest) throws Throwable {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("username 또는 password가 잘못되었습니다.", e);
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
        final String accessToken = jwtUtil.generateToken(userDetails);
        return new AuthResponse(accessToken);
    }

    @PostMapping("/signUp/email")
    public SignUpResponse signUpWithEmail(@RequestBody SignUpRequest signUpRequest) {
        Account account = accountService.signUpWithEmail(signUpRequest);
        return SignUpResponse.builder()
                .accountId(account.getAccountId())
                .build();
    }
}
