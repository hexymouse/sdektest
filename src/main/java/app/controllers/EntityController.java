package app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntityController {

    @GetMapping("/entity")
    public String getEntities() {
        return "list of entities";
    }

    @PostMapping("/entity")
    public String createEntity() {
        return "create entity";
    }
}
