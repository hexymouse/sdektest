package app.services;

import app.dto.EntityDto;
import app.entities.Entity;

import java.util.List;

public interface EntityService {
    void createEntity(EntityDto entityDto);

    List<Entity> getAllEntities();
}
