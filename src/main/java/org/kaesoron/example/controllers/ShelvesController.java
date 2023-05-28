package org.kaesoron.example.controllers;

import jakarta.validation.Valid;
import org.kaesoron.example.dao.ShelfDAO;
import org.kaesoron.example.models.Shelf;
import org.kaesoron.example.repository.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShelvesController {

    private final ShelfDAO shelfDAO;
    @Autowired
    private WarehousesRepository warehousesRepository;

    public ShelvesController(ShelfDAO shelfDAO) {
        this.shelfDAO = shelfDAO;
    }

    //Shelves for WH with stated ID
    @GetMapping("/{id}/shelves")
    public String index(@PathVariable("id") long id, Model model) {
        model.addAttribute("shelves", shelfDAO.index(id));
        return "/shelves/index";
    }
    //Shelves for WH with stated ID with "/" in URL
    @GetMapping("/{id}/shelves/")
    public String index2() {
        return "redirect:/{id}/shelves";
    }
    //Creating new shelf from index page
    @PostMapping("/{id}/shelves")
    public String create(@PathVariable("id") long id, @ModelAttribute("shelf") @Valid Shelf shelf) {
        Shelf newShelf = new Shelf();
        newShelf.setWarehouse(warehousesRepository.getReferenceById(id));
        shelfDAO.save(newShelf);
        return "redirect:/{id}/shelves/";
    }
    //Show separate shelf details
    @GetMapping("/shelves/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("shelf", shelfDAO.show(id));
        return "/shelves/show";
    }
    //Shelf deletion button
    @PostMapping("/shelves/{id}/delete/")
    public String delete(@PathVariable("id") int id) {
        long whId = shelfDAO.show(id).getWarehouse().getWarehouseId();
        String whIdText = "/"+String.valueOf(whId)+"/shelves";
        shelfDAO.delete(id);
        return "redirect:"+whIdText;
    }
}
