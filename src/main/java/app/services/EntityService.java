package app.services;

import app.dto.EntityDto;

import java.util.List;

public interface EntityService {
    EntityDto create(EntityDto entityDto);

    List<EntityDto> getAll();
}
