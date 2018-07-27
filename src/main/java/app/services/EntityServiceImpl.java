package app.services;

import app.dto.EntityDto;
import app.entities.Entity;
import app.repositories.EntityRepository;
import app.services.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {

    private final EntityRepository entityRepository;
    private final EntityMapper entityMapper;

    public EntityServiceImpl(EntityRepository entityRepository, EntityMapper entityMapper) {
        this.entityRepository = entityRepository;
        this.entityMapper = entityMapper;
    }

    public EntityDto create(EntityDto entityDto) {
        Entity entity = entityRepository.create(entityMapper.map(entityDto));
        return entityMapper.map(entity);
    }

    public List<EntityDto> getAll() {
        return entityMapper.mapAllToEntityDto(entityRepository.findAll());
    }
}
