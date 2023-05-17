package org.kaesoron.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WarehouseController {
    @GetMapping ("/hello")
    public String helloPage() {
        return "/warehouse/hello.html";
    }
}
