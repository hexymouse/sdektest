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
    private final List<EntityDto> list = new ArrayList<>();
    private final String filterString = "te";

    @Before
    public void setUpEntities() {
        EntityDto entityDto = new EntityDto();
        entityDto.setId(1L);
        entityDto.setName("test");
        list.add(entityDto);
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
        when(entityService.getAll()).thenReturn(list);
        List<EntityDto> list = entityService.getAll();
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        EntityDto entityDto = list.get(0);
        assertEquals("test", entityDto.getName());
    }

    @Test
    public void testFilterByName() {
        final List<Entity> entities = new ArrayList<>();

        when(entityMapper.mapAllToEntityDto(entities)).thenReturn(list);
        when(entityRepository.filterByName(filterString)).thenReturn(entities);

        EntityService entityService = new EntityServiceImpl(entityRepository, entityMapper);
        final Collection<EntityDto> result = entityService.filterByName(filterString);

        verify(entityMapper, times(1)).mapAllToEntityDto(entities);
        verify(entityRepository, times(1)).filterByName(filterString);
    }

    private EntityDto createEntityDto() {
        return new EntityDto();
    }

    private Entity createEntity() {
        return new Entity();
    }
}
