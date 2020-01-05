package kim.junhong.bookstudy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class StudyMember extends BaseEntity {

    @EmbeddedId
    private StudyAccountId studyAccountId;

    @Column
    private ApplyStatus applyStatus;
}
