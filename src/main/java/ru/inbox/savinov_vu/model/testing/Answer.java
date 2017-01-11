package ru.inbox.savinov_vu.model.testing;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Entity
@Table(name = "answers", uniqueConstraints = {@UniqueConstraint(columnNames = {"question_id"}, name = "answers_unique_question_idx")})
@Access(value = AccessType.FIELD)
public class Answer implements Persistable<Integer> {
    @Id
    @SequenceGenerator(name = "GLOBAL_SEQ", sequenceName = "GLOBAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOBAL_SEQ")
    protected Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    protected String name;
    @Transient
    private int number = Question.getSubNumber();


    public Answer() {
    }

    @JsonProperty("question")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    @Override
    public boolean isNew() {
        return (getId() == null);
    }

}
