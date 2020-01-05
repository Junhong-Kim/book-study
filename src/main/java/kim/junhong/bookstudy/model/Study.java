package kim.junhong.bookstudy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column
    private String title;

    @Column
    private String contents;

    @Column
    private StudyType studyType;

    @Column
    private StudyLevel studyLevel;

    @Column
    private String location;

    @Column
    private String maxPeopleCount;

    @Column
    private String minPeopleCount;

    @Column
    private LocalDateTime applyStartAt;

    @Column
    private LocalDateTime applyEndAt;

    @Column
    private LocalDateTime studyStartAt;

    @Column
    private LocalDateTime studyEndAt;

    @Column
    private StudyMeetingRepeat studyMeetingRepeat;

    @Column
    private LocalDateTime studyMeetingAt;
}
