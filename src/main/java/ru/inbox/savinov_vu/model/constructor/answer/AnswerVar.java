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
}
