package org.kaesoron.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SlotController {
    @GetMapping ("/slot/hello")
    public String helloPage() {
        return "/slot/hello.html";
    }
}
