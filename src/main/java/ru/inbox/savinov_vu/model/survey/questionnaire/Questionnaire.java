package ru.inbox.savinov_vu.model.survey.questionnaire;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.domain.Persistable;
import ru.inbox.savinov_vu.model.survey.question.Question;
import ru.inbox.savinov_vu.model.survey.survey.Survey;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questionnaires", uniqueConstraints = {@UniqueConstraint(columnNames = {"survey_id"}, name = "questionnaires_unique_survey_idx")})
@Access(value = AccessType.FIELD)
public class Questionnaire implements Persistable<Integer> {



    @Id
    @SequenceGenerator(name = "GLOBAL_SEQ", sequenceName = "GLOBAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOBAL_SEQ")
    protected Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    @JsonProperty("name")
    protected String name;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "questionnaire")
    private List<Question> question;

    @JsonProperty("survey")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;




    Questionnaire() {
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
