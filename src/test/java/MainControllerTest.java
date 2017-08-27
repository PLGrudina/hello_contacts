import com.task.controllers.MainController;
import com.task.models.Contact;
import com.task.services.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by PavelGrudina on 27.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

    @Mock
    private ContactService contactService;
    @InjectMocks
    private MainController mainController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void getNameFilterTest() throws Exception {
        mockMvc.perform(get("/hello/contacts")).andExpect(status().is4xxClientError());
    }

    @Test
    public void initCacheTest() {
        when(contactService.findAll()).thenReturn(Arrays.asList(new Contact("test1"), new Contact("test2")));

        mainController.initCache();

        verify(contactService).findAll();
        assertEquals(2, MainController.contactCache.size());
    }

    @Test
    public void getAllTest() throws Exception {
        mockMvc.perform(get("/hello/contacts/all")).andExpect(status().isOk());
    }
}
