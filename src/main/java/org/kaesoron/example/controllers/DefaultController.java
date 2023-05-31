package org.kaesoron.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class DefaultController {

    //List of warehouses
    @GetMapping("")
    public String index() {
        return "redirect:/warehouses";
    }
}
