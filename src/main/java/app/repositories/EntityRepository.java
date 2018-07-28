package app.repositories;

import app.entities.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.Objects;

@Repository
public class EntityRepository {

    private final JdbcTemplate jdbcTemplate;

    private final static String createQuery = "INSERT INTO entity (name) VALUES (?)";
    private final static String getAllQuery = "SELECT * FROM entity";

    @Autowired
    public EntityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Entity create(Entity entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement preparedStatement = connection.prepareStatement(createQuery, new String[]{"id"});
                    preparedStatement.setString(1, entity.getName());
                    return preparedStatement;
                },
                keyHolder
        );
        entity.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());

        return entity;
    }

    public Collection<Entity> findAll() {
        return jdbcTemplate.query(
                getAllQuery,
                (rs, rowNum) -> {
                    Entity entity = new Entity();
                    entity.setId(rs.getLong("id"));
                    entity.setName(rs.getString("name"));
                    return entity;
                }
        );
    }
}
