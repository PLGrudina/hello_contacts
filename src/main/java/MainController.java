import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PavelGrudina on 24.08.2017.
 */

    @Controller
    @EnableAutoConfiguration
    public class MainController {

        @RequestMapping(value = "/hello/contacts", method = RequestMethod.GET)
        @ResponseBody
        String getNameFilter (@RequestParam(value = "nameFilter", required = false) String nameFilter) {
            return nameFilter;
        }

        public static void main(String[] args) throws Exception {
            SpringApplication.run(MainController.class, args);
        }
    }

