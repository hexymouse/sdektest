package app.services.mappers;

import app.dto.EntityDto;
import app.entities.Entity;

import java.util.List;

public interface EntityMapper {
    Entity map(EntityDto entityDto);

    EntityDto map(Entity entity);
}
