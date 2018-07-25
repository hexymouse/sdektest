package app.controllers;

import app.dto.EntityDto;
import app.mappers.EntityMapper;
import app.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entity")
public class EntityController {

    private final EntityService entityService;
    private final EntityMapper entityMapper;

    @Autowired
    public EntityController(EntityService entityService, EntityMapper entityMapper) {
        this.entityMapper = entityMapper;
        this.entityService = entityService;
    }

    @GetMapping
    public List<EntityDto> getEntities() {
        return entityMapper.mapAllToEntityDto(entityService.getAllEntities());
    }

    @PostMapping
    public String createEntity() {

        return "entity created";
    }
}
