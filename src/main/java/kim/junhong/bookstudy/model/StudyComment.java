package kim.junhong.bookstudy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class StudyComment extends BaseEntity{

    @EmbeddedId
    private StudyAccountId studyAccountId;

    private String title;
}
