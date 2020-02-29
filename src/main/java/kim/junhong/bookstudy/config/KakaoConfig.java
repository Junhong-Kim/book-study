package kim.junhong.bookstudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class KakaoConfig {

    @Bean
    public WebClient kakaoApi() {
        return WebClient
                .builder()
                .baseUrl(System.getenv("KAKAO_API_URL"))
                .defaultHeader(
                        HttpHeaders.AUTHORIZATION, "KakaoAK " + System.getenv("KAKAO_APP_KEY")
                )
                .build();
    }
}
