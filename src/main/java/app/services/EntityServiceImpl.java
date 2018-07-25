package app.services;

import app.dto.EntityDto;
import org.springframework.stereotype.Service;

@Service
public class EntityServiceImpl implements EntityService {

    public void createEntity(EntityDto entityDto) {

    }

    public String getAllEntities() {
        return "list of entities";
    }
}
