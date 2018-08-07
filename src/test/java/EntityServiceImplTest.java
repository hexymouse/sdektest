import app.dto.EntityDto;
import app.entities.Entity;
import app.repositories.EntityRepository;
import app.services.EntityService;
import app.services.EntityServiceImpl;
import app.services.mappers.EntityMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EntityServiceImplTest {
    private final List<Entity> list = new ArrayList<>();

    @Before
    public void setUpEntities() {
        Entity entity = new Entity();
        entity.setId(1L);
        entity.setName("test");
        list.add(entity);
    }

    @Mock
    private EntityRepository entityRepository;

    @Mock
    private EntityMapper entityMapper;

    @Test
    public void testCreate() {
        final EntityDto entityDto = createEntityDto();
        final Entity entity = createEntity();

        when(entityMapper.map(entityDto)).thenReturn(entity);
        when(entityMapper.map(entity)).thenReturn(entityDto);
        when(entityRepository.create(entity)).thenReturn(entity);

        EntityService entityService = new EntityServiceImpl(entityRepository, entityMapper);
        final EntityDto result = entityService.create(entityDto);

        assertEquals(entityDto, result);
        verify(entityMapper, times(1)).map(entityDto);
        verify(entityRepository, times(1)).create(entity);
        verify(entityMapper, times(1)).map(entity);
    }

    @Test
    public void testGetAll() {
        EntityService entityService = new EntityServiceImpl(entityRepository, entityMapper);

        when(entityRepository.findAll()).thenReturn(list);

        List<EntityDto> list = entityService.getAll();
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    public void testFilterByName() {
        final EntityDto entityDto = createEntityDto();
        final Entity entity = createEntity();

        final List<Entity> entities = new ArrayList<>();

        String filterString = "te";
        when(entityMapper.map(entity)).thenReturn(entityDto);
        when(entityRepository.filterByName(filterString)).thenReturn(entities);

        EntityService entityService = new EntityServiceImpl(entityRepository, entityMapper);
        final Collection<EntityDto> result = entityService.filterByName(filterString);

        verify(entityRepository, times(1)).filterByName(filterString);
    }

    private EntityDto createEntityDto() {
        return new EntityDto();
    }

    private Entity createEntity() {
        return new Entity();
    }
}
