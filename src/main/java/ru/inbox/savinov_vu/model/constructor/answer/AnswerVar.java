package ru.inbox.savinov_vu.model.constructor.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;


@Entity
@Table(name = "answervars", uniqueConstraints = {@UniqueConstraint(columnNames = {"answerkit_id"}, name = "answersvar_unique_answerkit_idx")})
@Access(value = AccessType.FIELD)
public class AnswerVar implements Persistable<Integer> {
    @Id
    @SequenceGenerator(name = "CONSTRUCTOR_SEQ", sequenceName = "CONSTRUCTOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONSTRUCTOR_SEQ")
    protected Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    @JsonProperty("name")
    protected String name;

    @JsonProperty("answerKit")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answerkit_id", nullable = false)
    private AnswerKit answerKit;

    public AnswerVar() {
    }

    public AnswerKit getAnswerKit() {
        return answerKit;
    }

    public Integer getId() {
        return id;
    }


    @Override
    public boolean isNew() {
        return (getId() == null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerVar answerVar = (AnswerVar) o;

        if (id != null ? !id.equals(answerVar.id) : answerVar.id != null) return false;
        if (name != null ? !name.equals(answerVar.name) : answerVar.name != null) return false;
        return answerKit != null ? answerKit.equals(answerVar.answerKit) : answerVar.answerKit == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (answerKit != null ? answerKit.hashCode() : 0);
        return result;
    }
}
