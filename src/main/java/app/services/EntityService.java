package app.services;

import app.dto.EntityDto;
import org.springframework.stereotype.Service;

@Service
public class EntityService {

    public void createEntity(EntityDto entityDto) {

    }

    public String getAllEntities() {
        return "list of entities";
    }
}
