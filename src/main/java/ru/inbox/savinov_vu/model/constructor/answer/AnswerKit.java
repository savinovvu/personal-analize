package ru.inbox.savinov_vu.model.constructor.answer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "answerkits")
@Access(value = AccessType.FIELD)
@NoArgsConstructor
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

    public AnswerKit(String name, AnswerType answerType) {
        this.name = name;
        this.answerType = answerType;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerKit answerKit = (AnswerKit) o;

        if (id != null ? !id.equals(answerKit.id) : answerKit.id != null) return false;
        if (name != null ? !name.equals(answerKit.name) : answerKit.name != null) return false;
        return answerType == answerKit.answerType;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (answerType != null ? answerType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n(" +
                "" + id +
                ", '" + name + '\'' +
                ", " + answerType +
                ")";
    }
}
