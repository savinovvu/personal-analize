package ru.inbox.savinov_vu.model.quiz.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "questions", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"survey_id"}, name = "questions_unique_survey_idx"),
        })
@Access(value = AccessType.FIELD)
@NoArgsConstructor
public class Question {

    @Id
    @SequenceGenerator(name = "SURVEY_SEQ", sequenceName = "SURVEY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEY_SEQ")
    private Integer id;

    @Column(name = "number")
    @JsonProperty("number")
    private Integer number;


    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "questionVarId", nullable = false)
    @JsonProperty("questionVarId")
    private Integer questionVarId;

    @Column(name = "superQuestionVarId", nullable = true)
    @JsonProperty("superQuestionId")
    private Integer superQuestionId;

    @JsonProperty("survey")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "question")
    private List<Answer> answers;


    public Integer getId() {
        return id;
    }

    public Question setId(Integer id) {
        this.id = id;
        return this;
    }

    public Question setQuestionVarId(Integer questionVarId) {
        this.questionVarId = questionVarId;
        return this;
    }

    public Question setSuperQuestionId(Integer superQuestionId) {
        this.superQuestionId = superQuestionId;
        return this;
    }

    public Integer getQuestionVarId() {
        return questionVarId;
    }

    public Integer getSuperQuestionId() {
        return superQuestionId;
    }

    public Survey getSurvey() {
        return survey;
    }

    public Question setSurvey(Survey survey) {
        this.survey = survey;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public Question setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public Question setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (id != null ? !id.equals(question.id) : question.id != null) return false;
        if (number != null ? !number.equals(question.number) : question.number != null) return false;
        if (name != null ? !name.equals(question.name) : question.name != null) return false;
        if (questionVarId != null ? !questionVarId.equals(question.questionVarId) : question.questionVarId != null)
            return false;
        return superQuestionId != null ? superQuestionId.equals(question.superQuestionId) : question.superQuestionId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (questionVarId != null ? questionVarId.hashCode() : 0);
        result = 31 * result + (superQuestionId != null ? superQuestionId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nQuestion{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", questionVarId=" + questionVarId +
                ", superQuestionId=" + superQuestionId +
                ", survey=" + survey +
                "}";
    }
}
