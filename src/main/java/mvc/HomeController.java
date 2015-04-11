package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chriscerami on 4/11/15.
 */

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
