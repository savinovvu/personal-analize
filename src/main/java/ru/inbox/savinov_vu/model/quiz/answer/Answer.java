package ru.inbox.savinov_vu.model.quiz.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import ru.inbox.savinov_vu.model.quiz.question.Question;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;

import javax.persistence.*;

@Entity
@Table(name = "answers", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"questionnaire_id"}, name = "answers_unique_questionnaire_idx"),
                @UniqueConstraint(columnNames = {"question_id"}, name = "answers_unique_question_idx")
        })
@Access(value = AccessType.FIELD)
@NoArgsConstructor
public class Answer implements Persistable<Integer>, Comparable<Answer> {
    @Id
    @SequenceGenerator(name = "SURVEY_SEQ", sequenceName = "SURVEY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEY_SEQ")
    protected Integer id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    protected String name;

    @JsonProperty("questionnaire")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questionnaire_id", nullable = false)
    private Questionnaire questionnaire;

    @JsonProperty("question")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public Answer setQuestion(Question question) {
        this.question = question;
        return this;
    }

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

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Answer setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (name != null ? !name.equals(answer.name) : answer.name != null) return false;

        return question != null ? question.equals(answer.question) : answer.question == null;
    }

    @Override
    public int hashCode() {
        int result = (name != null ? name.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        return result;
    }


    @Override
    public int compareTo(Answer o) {
        return this.id > o.id ? 1 : 0;
    }


    @Override
    public String toString() {
        return "\n(" +
                "" + id +
                ", '" + name + '\'' +
                ", " + questionnaire.getId() +
                ", " + question.getId() +
                ")";
    }
}
