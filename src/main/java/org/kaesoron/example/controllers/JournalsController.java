package org.kaesoron.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/journals")
public class JournalsController {
    @GetMapping ("/")
    public String helloPage(@RequestParam(value = "type", required = false) String type,
                            Model model) {
        if (type==null) {
            model.addAttribute("message", "Info about all operations");
        } else {
            model.addAttribute("message", "Info about operations type: "+type);
        }
        return "/journals/hello.html";
    }
}
