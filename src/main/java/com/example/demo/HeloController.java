package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index.html";
    }
}
