package app.controllers;

import app.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity")
public class EntityController {

    private final EntityService entityService;

    @Autowired
    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping
    public String getEntities() {
        return "qew";
    }

    @PostMapping
    public String createEntity() {

        return "entity created";
    }
}
