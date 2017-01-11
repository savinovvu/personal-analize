package ru.inbox.savinov_vu.model.testing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions", uniqueConstraints = {@UniqueConstraint(columnNames = {"questionnaire_id"}, name = "questions_unique_questionnaire_idx")})
@Access(value = AccessType.FIELD)
public class Question implements Persistable<Integer> {

    private static int subNumber = 0;

    @Id
    @SequenceGenerator(name = "GLOBAL_SEQ", sequenceName = "GLOBAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOBAL_SEQ")
    protected Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    protected String name;
    private int number = Questionnaire.getSubNumber();
    ;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "question")
    private List<Answer> answer;

    @JsonProperty("questionnaire")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questionnaire_id", nullable = false)
    private Questionnaire questionnaire;

    public Question() {
    }


    public static int getSubNumber() {
        return ++subNumber;
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
