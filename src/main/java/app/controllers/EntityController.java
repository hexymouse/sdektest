package app.controllers;

import app.dto.EntityDto;
import app.services.EntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity")
public class EntityController {

    @GetMapping
    public String getEntities() {
        EntityService service = new EntityService();
        return service.getAllEntities();
    }

    @PostMapping
    public String createEntity() {
        EntityService service = new EntityService();
        EntityDto entityDto = new EntityDto();
        service.createEntity(entityDto);
        return "entity created";
    }
}
