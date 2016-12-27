package ru.inbox.savinov_vu.model.personal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.inbox.savinov_vu.model.abstratModel.NamedEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group extends NamedEntity{

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "order")
    @JsonProperty("products")
    private List<Person> persons;
}
