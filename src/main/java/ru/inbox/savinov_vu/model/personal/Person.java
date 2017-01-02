package ru.inbox.savinov_vu.model.personal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.inbox.savinov_vu.model.abstratModel.NamedEntity;

import javax.persistence.*;


@Entity
@Table(name = "persons", uniqueConstraints = {@UniqueConstraint(columnNames = {"group_id"}, name = "persons_unique_group_idx")})
public class Person extends NamedEntity {



  //  @JsonProperty("group")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL, CascadeType.PERSIST})
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

}
