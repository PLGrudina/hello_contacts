import com.task.dao.ContactDao;
import com.task.models.Contact;
import com.task.services.ContactService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by PavelGrudina on 27.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ContactServiceTest {

    @Mock
    private ContactService contactService;
    @Mock
    private ContactDao contactDao;


    @Test
    public void save() throws Exception {
        Contact jonh = new Contact("John");
        contactService.save(jonh);
        Assert.assertNotNull(jonh.getId());
    }

//    @Test
//    public void findAll() throws Exception {
//        List<Contact> expected = contactService.findAll();
//        List<Contact> actual = new ArrayList<>();
//        actual.addAll((Collection<? extends Contact>) contactDao.findAll());
//        Assert.assertEquals(expected,actual);
//
//
//    }
}
