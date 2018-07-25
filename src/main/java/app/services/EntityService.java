package app.services;

import app.dto.EntityDto;

public interface EntityService {
    public void createEntity(EntityDto entityDto);

    public String getAllEntities();
}
