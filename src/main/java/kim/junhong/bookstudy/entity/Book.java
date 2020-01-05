package kim.junhong.bookstudy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String Contents;

    @Column
    private String url;

    @Column
    private String isbn;

    @Column
    private LocalDateTime dateTime;

    @Column
    private String authors;

    @Column
    private String publisher;

    @Column
    private String translators;

    @Column
    private String price;

    @Column
    private String salePrice;

    @Column
    private String thumbnail;

    @Column
    private Status status;
}
