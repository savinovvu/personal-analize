package ru.inbox.savinov_vu.model.constructor.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Persistable;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;

import javax.persistence.*;
import java.util.List;


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

   // @NotEmpty
    @Column(name = "name", nullable = true)
   // @SafeHtml
    @JsonProperty("name")
    protected String name;


    @JsonProperty("answerKit")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answerkit_id", nullable = false)
    private AnswerKit answerKit;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "questionVar")
    private List<Answer> answers;


    @JsonProperty("questionKit")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questionkit_id", nullable = true)
    private QuestionKit questionKit;

    @JsonProperty("questionVar")
    @Column(name = "superQuestionVarId", nullable = true)
    private Integer superQuestionVarId;




    public QuestionVar() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public QuestionKit getQuestionKit() {
        return questionKit;
    }


    public Integer getSuperQuestionVarId() {
        return superQuestionVarId;
    }

    public void setSuperQuestionVarId(Integer superQuestionVarId) {
        this.superQuestionVarId = superQuestionVarId;
    }

    @Override
    public boolean isNew() {
        return (getId() == null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionVar that = (QuestionVar) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (answerKit != null ? !answerKit.equals(that.answerKit) : that.answerKit != null) return false;
        return questionKit != null ? questionKit.equals(that.questionKit) : that.questionKit == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (answerKit != null ? answerKit.hashCode() : 0);
        result = 31 * result + (questionKit != null ? questionKit.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "QuestionVar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", answerKit=" + answerKit +
                ", questionKit=" + questionKit +
                '}';
    }
}
