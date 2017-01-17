package ru.inbox.savinov_vu.model.constructor.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.domain.Persistable;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;

import javax.persistence.*;


@Entity
@Table(name = "qustionvar", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"questionkit_id"}, name = "questionvar_unique_questionkit_idx"),
        @UniqueConstraint(columnNames = {"answerkit_id"}, name = "questionvar_unique_answerkit_idx")
        })
@Access(value = AccessType.FIELD)
public class QuestionVar implements Persistable<Integer> {


    @Id
    @SequenceGenerator(name = "GLOBAL_SEQ", sequenceName = "GLOBAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOBAL_SEQ")
    protected Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    protected String name;


    @JsonProperty("answerkit")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answerkit_id", nullable = false)
    private AnswerKit answerKit;


    @JsonProperty("questionkit")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questionkit_id", nullable = false)
    private QuestionKit questionKit;









    public QuestionVar() {
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public boolean isNew() {
        return (getId() == null);
    }


}
