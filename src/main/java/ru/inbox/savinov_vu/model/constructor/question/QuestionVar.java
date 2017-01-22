package ru.inbox.savinov_vu.model.constructor.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.domain.Persistable;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;

import javax.persistence.*;


@Entity
@Table(name = "questionvars", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"questionkit_id"}, name = "questionvar_unique_questionkit_idx"),
                @UniqueConstraint(columnNames = {"answerkit_id"}, name = "questionvar_unique_answerkit_idx")
        })
@Access(value = AccessType.FIELD)
public class QuestionVar implements Persistable<Integer> {


    @Id
    @SequenceGenerator(name = "CONSTRUCTOR_SEQ", sequenceName = "CONSTRUCTOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONSTRUCTOR_SEQ")
    protected Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    @JsonProperty("name")
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

    public QuestionKit getQuestionKit() {
        return questionKit;
    }

    public Integer getId() {
        return id;
    }


    @Override
    public boolean isNew() {
        return (getId() == null);
    }


}
