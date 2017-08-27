import com.task.dao.ContactDao;
import com.task.models.Contact;
import com.task.services.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by PavelGrudina on 27.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {

    @Mock
    private ContactDao contactDao;
    @InjectMocks
    private ContactService contactService;


    @Test
    public void save() throws Exception {
        Contact jonh = new Contact("John");
        when(contactDao.save(jonh)).thenReturn(new Contact("Saved"));
        Contact saved = contactService.save(jonh);

        assertEquals("Saved", saved.getName());
    }

    @Test
    public void findAll() throws Exception {
        contactService.save(new Contact("Aria"));
        contactService.save(new Contact("Cleo"));
        when(contactDao.findAll()).thenReturn(Arrays.asList(new Contact("Aria"), new Contact("Cleo")));
        List<Contact> actual = contactService.findAll();

        assertEquals(2, actual.size());
    }
}
