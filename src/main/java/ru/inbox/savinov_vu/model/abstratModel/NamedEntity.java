package ru.inbox.savinov_vu.model.abstratModel;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass

public abstract class NamedEntity extends BaseEntity {

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    protected String name;

    public NamedEntity() {
        super();
    }

    protected NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "name='" + name + '\'' +
                '}';
    }
}