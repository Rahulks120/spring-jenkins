package com.ivoyant.springboot_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String gotoWelcomePage(Model model) {
        model.addAttribute("name","Rahul");
        return "welcome";
    }

}
