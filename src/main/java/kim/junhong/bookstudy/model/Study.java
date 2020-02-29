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
    private Long studyId;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    private String title;
    private String contents;
    private StudyType studyType;
    private StudyLevel studyLevel;
    private String location;
    private int maxPeopleCount;
    private int minPeopleCount;
    private LocalDateTime applyStartAt;
    private LocalDateTime applyEndAt;
    private LocalDateTime studyStartAt;
    private LocalDateTime studyEndAt;
    private StudyMeetingRepeat studyMeetingRepeat;
    private LocalDateTime studyMeetingAt;
}
