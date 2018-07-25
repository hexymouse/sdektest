package app.mappers;

import app.dto.EntityDto;
import app.entities.Entity;

import java.util.List;

public interface EntityMapper {
    Entity mapToEntity(EntityDto entityDto);

    EntityDto mapToEntityDto(Entity entity);

    List<EntityDto> mapAllToEntityDto(List<Entity> entities);
}
