package nl.yacht.airportexersize.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("xyzairline")
public class XyzairlineController {

    @GetMapping()
    public String index(Map<String, Object> model){
        return "xyzairline";
    }
}