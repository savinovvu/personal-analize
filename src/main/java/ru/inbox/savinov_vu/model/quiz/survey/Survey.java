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
    private Long count;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "survey")
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
    @JoinColumn(name = "department_id", nullable = true)
    private Department department;

    @JsonProperty("group")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", nullable = true)
    private Group group;




    public Survey() {
    }

    public Survey setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }


    @Override
    public boolean isNew() {
        return (getId() == null);
    }

    public Survey setCount(Long count) {
        this.count = count;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Survey setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Long getCount() {
        return count;
    }

    public List<Questionnaire> getQuestionnaire() {
        return questionnaire;
    }

    public Survey setQuestionnaire(List<Questionnaire> questionnaire) {
        this.questionnaire = questionnaire;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Survey setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public QuestionKit getQuestionKit() {
        return questionKit;
    }

    public Survey setQuestionKit(QuestionKit questionKit) {
        this.questionKit = questionKit;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public Survey setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public Group getGroup() {
        return group;
    }

    public Survey setGroup(Group group) {
        this.group = group;
        return this;
    }
}
