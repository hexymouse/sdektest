package app.entities;

import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="entity")
public class Entity {

    @Id
    private Long id;
    private String name;

    public Entity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
