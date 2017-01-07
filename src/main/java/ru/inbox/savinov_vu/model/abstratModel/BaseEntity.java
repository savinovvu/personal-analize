package ru.inbox.savinov_vu.model.abstratModel;

import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
// http://stackoverflow.com/questions/594597/hibernate-annotations-which-is-better-field-or-property-access
@Access(AccessType.FIELD)
/*@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)*/
public abstract  class BaseEntity /*implements Persistable<Integer> */{
    //public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "GLOBAL_SEQ", sequenceName = "GLOBAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOBAL_SEQ")
    @GenericGenerator(name= "increment", strategy= "increment")
    // PROPERTY access for id due to bug: https://hibernate.atlassian.net/browse/HHH-3718
    @Access(value = AccessType.PROPERTY)
    protected Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @SafeHtml
    protected String name;




    protected BaseEntity() {
    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   // @Override
    public Integer getId() {
        return id;
    }

   // @Override
    public boolean isNew() {
        return (getId() == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;

        return null != getId() && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return (getId() == null) ? 0 : getId();
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                '}';
    }
}

