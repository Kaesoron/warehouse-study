package org.kaesoron.example.controllers;

import org.kaesoron.example.dao.CommodityDAO;
import org.kaesoron.example.dao.JournalDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/journals")
public class JournalsController {
    private final JournalDAO journalDAO;

    public JournalsController(JournalDAO journalDAO) {
        this.journalDAO = journalDAO;
    }
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("journals", journalDAO.index());
        return "/journals/index";
    }
    //Total list of commodities with "/" in URL
    @GetMapping("/")
    public String index2() {
        return "redirect:/journals";
    }
}
