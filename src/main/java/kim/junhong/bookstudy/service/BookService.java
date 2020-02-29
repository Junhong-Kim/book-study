package kim.junhong.bookstudy.service;

import kim.junhong.bookstudy.config.KakaoConfig;
import kim.junhong.bookstudy.dto.SearchBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final KakaoConfig kakaoConfig;

    public SearchBookResponse getSearchBooks(String query, String page, String size) {
        return kakaoConfig.kakaoApi()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v3/search/book")
                        .queryParam("query", query)
                        .queryParam("page", page)
                        .queryParam("size", size)
                        .build()
                )
                .retrieve()
                .bodyToMono(SearchBookResponse.class)
                .block();
    }
}
