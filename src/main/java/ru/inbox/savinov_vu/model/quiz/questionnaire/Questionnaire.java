package ru.inbox.savinov_vu.model.quiz.questionnaire;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.domain.Persistable;
import ru.inbox.savinov_vu.model.quiz.question.Question;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.util.json.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "questionnaires", uniqueConstraints = {@UniqueConstraint(columnNames = {"survey_id"}, name = "questionnaires_unique_survey_idx")})
@Access(value = AccessType.FIELD)
public class Questionnaire implements Persistable<Integer> {


    @Id
    @SequenceGenerator(name = "GLOBAL_SEQ", sequenceName = "GLOBAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOBAL_SEQ")
    private Integer id;

    @NotEmpty
    @Column(name = "number", nullable = false)
    @SafeHtml
    @JsonProperty("number")
    private Integer number;

    @Column(name = "createDate")
    @JsonProperty("createDate")
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate date;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "questionnaire")
    private List<Question> question;

    @JsonProperty("quiz")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;


    public Questionnaire() {
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
