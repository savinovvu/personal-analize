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
    @SequenceGenerator(name = "GLOBAL_SEQ", sequenceName = "GLOBAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOBAL_SEQ")
    protected Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    protected String name;


    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    @JsonProperty("type")
    private AnswerType answerType;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "answerKit")
    private List<QuestionVar> questionVars;

    @JsonProperty("answers")
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "answerKit")
    private List<AnswerVar> answerVars;


}
