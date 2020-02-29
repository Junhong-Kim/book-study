package kim.junhong.bookstudy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;
    private String contents;
    private String url;
    private String isbn;
    private String authors;
    private String publisher;
    private LocalDateTime publish_at;
    private String translators;
    private String price;
    private String salePrice;
    private String thumbnail;
    private Status book_status;
}
