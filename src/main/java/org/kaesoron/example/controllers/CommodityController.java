package org.kaesoron.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommodityController {
    @GetMapping ("/commodity/hello")
    public String helloPage() {
        return "/commodity/hello.html";
    }
}
