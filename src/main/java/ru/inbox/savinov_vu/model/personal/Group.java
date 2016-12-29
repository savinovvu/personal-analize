package ru.inbox.savinov_vu.model.personal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.inbox.savinov_vu.model.abstratModel.NamedEntity;

import javax.persistence.*;
import java.util.List;

@Entity
/*@NamedEntityGraph(name = Group.GRAPH_WITH_PERSON, attributeNodes = {@NamedAttributeNode("persons")})*/
@Table(name = "groups" +
        "")
public class Group extends NamedEntity{
  /*  public static final String GRAPH_WITH_PERSON = "Group.withPersons";*/

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "group")
    @JsonProperty("persons")
    private List<Person> persons;
}
