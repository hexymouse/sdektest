package app.mappers;

import app.dto.EntityDto;
import app.entities.Entity;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class EntityMapperImpl implements EntityMapper {

    public Entity mapToEntity(EntityDto entityDto) {
        Entity entity = new Entity();
        entity.setId(entityDto.getId());
        entity.setName(entityDto.getName());

        return entity;
    }

    public EntityDto mapToEntityDto(Entity entity) {
        EntityDto dto = new EntityDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    public List<EntityDto> mapAllToEntityDto(List<Entity> entities) {
        return null;
    }
}
