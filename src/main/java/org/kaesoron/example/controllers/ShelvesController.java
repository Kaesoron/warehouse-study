package org.kaesoron.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shelves")
public class ShelvesController {
    @GetMapping ("/")
    public String helloPage(@RequestParam(value = "number", required = false) Integer number,
                            Model model) {
        if (number==null) {
            model.addAttribute("message", "Info about all shelves");
        } else {
            model.addAttribute("message", "Info about shelf #"+number);
        }
        return "/shelves/hello.html";
    }
}
