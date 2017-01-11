package ru.inbox.savinov_vu.model.testing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questionnaires", uniqueConstraints = {@UniqueConstraint(columnNames = {"testing_id"}, name = "questionnaires_unique_testing_idx")})
public class Questionnaire  implements Persistable<Integer> {

    private static int subNumber = 0;


    @Id
    @SequenceGenerator(name = "GLOBAL_SEQ", sequenceName = "GLOBAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOBAL_SEQ")
    @Access(value = AccessType.PROPERTY)
    protected Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    protected String name;

    private int number;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "questionnaire")
    private List<Question> question;

    @JsonProperty("testing")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "testing_id", nullable = false)
    private Testing testing;



    Questionnaire() {
        number = Testing.getSubNumber();
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
