package org.kaesoron.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/commodities")
public class CommoditiesController {
    @GetMapping ("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            Model model) {
        if (name==null) {
            model.addAttribute("message", "Info about all commodities");
        } else {
            model.addAttribute("message", "Info about commodity "+name);
        }
        return "/commodities/hello.html";
    }
}
