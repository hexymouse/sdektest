package app.dto;

import javax.validation.constraints.Size;

public class EntityDto {

    private Long id;

    @Size(min = 1, max = 255)
    private String name;

    public EntityDto() {}

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
