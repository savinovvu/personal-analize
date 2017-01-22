package ru.inbox.savinov_vu.model.constructor.answer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "answerkits")
@Access(value = AccessType.FIELD)
public class AnswerKit {

    @Id
    @SequenceGenerator(name = "CONSTRUCTOR_SEQ", sequenceName = "CONSTRUCTOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONSTRUCTOR_SEQ")
    protected Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    @JsonProperty("name")
    protected String name;


    @Enumerated(EnumType.STRING)
    @Column(name = "answerType")
    @JsonProperty("answerType")
    private AnswerType answerType;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "answerKit")
    private List<QuestionVar> questionVars;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "answerKit")
    private List<AnswerVar> answerVars;

    public Integer getId() {
        return id;
    }


}
