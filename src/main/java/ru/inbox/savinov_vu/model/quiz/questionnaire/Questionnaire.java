package ru.inbox.savinov_vu.model.quiz.questionnaire;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.domain.Persistable;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.util.json.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "questionnaires", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"survey_id"}, name = "questionnaires_unique_survey_idx")})
@Access(value = AccessType.FIELD)
public class Questionnaire implements Persistable<Integer> {


    @Id
    @SequenceGenerator(name = "SURVEY_SEQ", sequenceName = "SURVEY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEY_SEQ")
    private Integer id;


    @Column(name = "number", nullable = false)
    @JsonProperty("number")
    private Integer number;

    @Column(name = "createDate")
    @JsonProperty("createDate")
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate date;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "questionnaire")
    private List<Answer> answers;

    @JsonProperty("survey")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;


    public Questionnaire() {
    }

    public Questionnaire(LocalDate date) {
        this.date = date;
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

    public Integer getNumber() {
        return number;
    }

    public Questionnaire setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Survey getSurvey() {
        return survey;
    }

    public Questionnaire setSurvey(Survey survey) {
        this.survey = survey;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Questionnaire that = (Questionnaire) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return survey != null ? survey.equals(that.survey) : that.survey == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (survey != null ? survey.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id=" + id +
                ", number=" + number +
                ", date=" + date +
                ", survey=" + survey +
                '}';
    }
}
