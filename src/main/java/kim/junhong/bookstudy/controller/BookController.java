package kim.junhong.bookstudy.controller;

import kim.junhong.bookstudy.dto.SearchBookResponse;
import kim.junhong.bookstudy.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/search")
    public SearchBookResponse getSearchBook(HttpServletRequest request) {
        return bookService.getSearchBook(
                request.getParameter("query"),
                request.getParameter("page"),
                request.getParameter("size")
        );
    }
}
