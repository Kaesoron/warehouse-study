package org.kaesoron.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JournalController {
    @GetMapping ("/journal/hello")
    public String helloPage() {
        return "/journal/hello.html";
    }
}
