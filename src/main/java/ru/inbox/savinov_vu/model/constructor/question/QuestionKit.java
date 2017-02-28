package ru.inbox.savinov_vu.model.constructor.question;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questionkits")
@Access(value = AccessType.FIELD)
public class QuestionKit implements Persistable<Integer> {


    @Id
    @SequenceGenerator(name = "CONSTRUCTOR_SEQ", sequenceName = "CONSTRUCTOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONSTRUCTOR_SEQ")
    protected Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    @JsonProperty("name")
    protected String name;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "questionKit")
    private List<QuestionVar> questionVars;


    public QuestionKit() {
    }


    public Integer getId() {
        return id;
    }


    @Override
    public boolean isNew() {
        return (getId() == null);

    }

    public QuestionKit setId(Integer id) {
        this.id = id;
        return this;
    }
}
