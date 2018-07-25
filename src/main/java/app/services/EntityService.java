package app.services;

import app.dto.EntityDto;

public interface EntityService {
    void createEntity(EntityDto entityDto);

    String getAllEntities();
}
