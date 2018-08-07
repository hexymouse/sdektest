package app.services.mappers;

import app.dto.EntityDto;
import app.entities.Entity;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMapperImpl implements EntityMapper {

    public Entity map(EntityDto entityDto) {
        Entity entity = new Entity();
        entity.setId(entityDto.getId());
        entity.setName(entityDto.getName());

        return entity;
    }

    public EntityDto map(Entity entity) {
        EntityDto dto = new EntityDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }
}
