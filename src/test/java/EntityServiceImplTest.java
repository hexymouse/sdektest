import app.dto.EntityDto;
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
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EntityServiceImplTest {
    private final List<EntityDto> list = new ArrayList<>();

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
        EntityService entityService = new EntityServiceImpl(entityRepository, entityMapper);
        EntityDto entityDto = new EntityDto();
        EntityDto mockEntityDto = new EntityDto();
        mockEntityDto.setId(2L);
        when(entityService.create(entityDto)).thenReturn(mockEntityDto);
        EntityDto entity = entityService.create(entityDto);
        assertEquals(entity, mockEntityDto);
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
}
