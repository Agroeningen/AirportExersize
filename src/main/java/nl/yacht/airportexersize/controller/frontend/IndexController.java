package nl.yacht.template.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("")
public class IndexController {

    @GetMapping()
    public String index(Map<String, Object> model){
        return "index";
    }
}
