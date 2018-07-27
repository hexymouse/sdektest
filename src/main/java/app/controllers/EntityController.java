package app.controllers;

import app.dto.EntityDto;
import app.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entity")
public class EntityController {

    private final EntityService entityService;

    @Autowired
    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping
    public List<EntityDto> getEntities() {
        return entityService.getAll();
    }

    @PostMapping
    public EntityDto createEntity(@RequestBody EntityDto entityDto) {
        return entityService.create(entityDto);
    }
}
