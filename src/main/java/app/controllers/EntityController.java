package app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/entity")
public class EntityController {

    @GetMapping
    public String getEntities() {
        return "list of entities";
    }

    @PostMapping
    public String createEntity() {
        return "create entity";
    }
}
