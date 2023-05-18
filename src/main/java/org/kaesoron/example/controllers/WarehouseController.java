package org.kaesoron.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WarehouseController {
    @GetMapping ("/warehouse/hello")
    public String helloPage() {
        return "/warehouse/hello.html";
    }
}
