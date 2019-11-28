package pl.lanshela.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage (){
        return "index/index";
    }

}
