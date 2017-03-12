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
    @SequenceGenerator(name = "SURVEY_SEQ", sequenceName = "SURVEY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEY_SEQ")
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Survey survey = (Survey) o;

        if (id != null ? !id.equals(survey.id) : survey.id != null) return false;
        if (comment != null ? !comment.equals(survey.comment) : survey.comment != null) return false;
        if (count != null ? !count.equals(survey.count) : survey.count != null) return false;

        if (date != null ? !date.equals(survey.date) : survey.date != null) return false;
        if (questionKit != null ? !questionKit.equals(survey.questionKit) : survey.questionKit != null) return false;
        if (department != null ? !department.equals(survey.department) : survey.department != null) return false;
        return group != null ? group.equals(survey.group) : survey.group == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (questionKit != null ? questionKit.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", count=" + count +
                ", date=" + date +
                ", questionKit=" + questionKit +
                ", department=" + department +
                ", group=" + group +
                '}';
    }
}
