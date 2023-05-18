package org.kaesoron.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShelfController {
    @GetMapping ("/shelf/hello")
    public String helloPage() {
        return "/shelf/hello.html";
    }
}
