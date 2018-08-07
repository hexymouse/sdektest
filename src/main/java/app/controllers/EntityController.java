package app.controllers;

import app.dto.EntityDto;
import app.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public EntityDto createEntity(@RequestBody @Valid EntityDto entityDto) {
        return entityService.create(entityDto);
    }

    @RequestMapping("/filter")
    @GetMapping
    public List<EntityDto> filterByName(@RequestParam("name") String name) {
        return entityService.filterByName(name);
    }
}
