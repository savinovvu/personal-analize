package ru.inbox.savinov_vu.model.quiz.survey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.domain.Persistable;
import ru.inbox.savinov_vu.model.constructor.question.QuestionKit;
import ru.inbox.savinov_vu.model.personal.Department;
import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;
import ru.inbox.savinov_vu.util.json.JsonDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "surveys")
@Access(value = AccessType.FIELD)
public class Survey implements Persistable<Integer> {

    @Id
    @SequenceGenerator(name = "GLOBAL_SEQ", sequenceName = "GLOBAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOBAL_SEQ")
    private Integer id;

    @Column(name = "comment", nullable = false)
    @JsonProperty("comment")
    private String comment;

    @JsonProperty("count")
    @Transient
    private String count;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "survey")
    private List<Questionnaire> questionnaire;


    @Column(name = "createDate")
    @JsonProperty("createDate")
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate date;


    @JsonProperty("questionKit")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questionKit_id", nullable = false)
    private QuestionKit questionKit;

    @JsonProperty("department")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @JsonProperty("group")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;



    public Survey() {}
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    @Override
    public boolean isNew() {
        return (getId() == null);
    }


}
