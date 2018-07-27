package app.repositories;

import app.entities.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntityRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EntityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Entity create(Entity entity) {
        final String query = "INSERT INTO entity (name) VALUES (?)";

        jdbcTemplate.update(query, entity.getName());

        return entity;
    }

    public List<Entity> findAll() {
        final String query = "SELECT * FROM entity";

        return jdbcTemplate.query(
                query,
                (rs, rowNum) -> {
                    Entity entity = new Entity();
                    entity.setId(rs.getLong("id"));
                    entity.setName(rs.getString("name"));
                    return entity;
                }
        );
    }
}
