import config.PersistenceConfig;
import dao.DbInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by PavelGrudina on 24.08.2017.
 */

@Controller
@EnableAutoConfiguration
public class MainController {


    @RequestMapping(value = "/hello/contacts", method = RequestMethod.GET)
    @ResponseBody
    String getNameFilter(@RequestParam(value = "nameFilter", required = false) String nameFilter) {
        return nameFilter;
    }


    public static void main(String[] args) throws Exception {

        SpringApplication.run(new Class<?>[] {MainController.class, PersistenceConfig.class}, args);

//        DbInit dbInit = new DbInit();
//        dbInit.init();

    }

}

