package ru.inbox.savinov_vu.model.constructor.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Persistable;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;

import javax.persistence.*;


@Entity
@Table(name = "questionvars", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"questionkit_id"}, name = "questionvar_unique_questionkit_idx"),
                @UniqueConstraint(columnNames = {"answerkit_id"}, name = "questionvar_unique_answerkit_idx")
        })
@Access(value = AccessType.FIELD)
public class QuestionVar implements Persistable<Integer>, Comparable<QuestionVar> {


    @Id
    @SequenceGenerator(name = "CONSTRUCTOR_SEQ", sequenceName = "CONSTRUCTOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONSTRUCTOR_SEQ")
    private Integer id;

    @Column(name = "number")
    @JsonProperty("number")
    private Integer number;

    @Column(name = "name", nullable = true)
    @JsonProperty("name")
    private String name;

    @JsonProperty("questionVar")
    @Column(name = "superQuestionVarId", nullable = true)
    private Integer superQuestionVarId;


    @JsonProperty("answerKit")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answerkit_id", nullable = true)
    private AnswerKit answerKit;


    @JsonProperty("questionKit")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questionkit_id", nullable = false)
    private QuestionKit questionKit;


    public QuestionVar() {
    }

    public QuestionVar(String name) {
        this.name = name;
    }

    public QuestionVar(String name, Integer superQuestionVarId, AnswerKit answerKit, QuestionKit questionKit) {
        this.name = name;
        this.superQuestionVarId = superQuestionVarId;
        this.answerKit = answerKit;
        this.questionKit = questionKit;
    }

    public Integer getId() {
        return id;
    }

    public QuestionVar setId(Integer id) {
        this.id = id;
        return this;
    }

    public QuestionVar setName(String name) {
        this.name = name;
        return this;
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

    public Integer getNumber() {
        return number;
    }

    public QuestionVar setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public QuestionVar setQuestionKit(QuestionKit questionKit) {
        this.questionKit = questionKit;
        return this;
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

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return questionKit != null ? questionKit.getName().equals(that.questionKit.getName()) : that.questionKit == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (questionKit != null ? questionKit.hashCode() : 0);
        result = 31 * result + (superQuestionVarId != null ? superQuestionVarId.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(QuestionVar o) {
        return this.id > o.id ? 1 : 0;
    }

    @Override
    public String toString() {
        return "\n(" +
                "" + id +
                ", " + number +
                ", '" + name + '\'' +
                ", " + superQuestionVarId +
                ", " + answerKit.getId() +
                ", " + questionKit.getId() +
                ")";
    }
}
