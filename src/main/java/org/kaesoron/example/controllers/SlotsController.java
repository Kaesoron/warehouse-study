package org.kaesoron.example.controllers;

import jakarta.validation.Valid;
import org.kaesoron.example.dao.SlotDAO;
import org.kaesoron.example.models.Slot;
import org.kaesoron.example.repository.ShelvesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class SlotsController {
    private final SlotDAO slotDAO;
    @Autowired
    private ShelvesRepository shelvesRepository;

    public SlotsController(SlotDAO slotDAO) {
        this.slotDAO = slotDAO;
    }

    //Slots for shelf with stated ID
    @GetMapping("/shelves/{id}/slots")
    public String index(@PathVariable("id") long id, Model model) {
        model.addAttribute("slots", slotDAO.index(id));
        return "/slots/index";
    }
    //Slots for shelf with stated ID with "/" in URL
    @GetMapping("/shelves/{id}/slots/")
    public String index2() {
        return "redirect:/shelves/{id}/slots";
    }
    //Creating new slot from index page
    @PostMapping("shelves/{id}/slots")
    public String create(@PathVariable("id") long id, @ModelAttribute("slot") @Valid Slot slot) {
        Slot newSlot = new Slot();
        newSlot.setEmpty(true);
        newSlot.setShelf(shelvesRepository.getReferenceById(id));
        slotDAO.save(newSlot);
        return "redirect:/shelves/{id}/slots";
    }
    //Show separate slot details
    @GetMapping("slots/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("slot", slotDAO.show(id));
        return "/slots/show";
    }
    //Edit of existing slot (hyperlink)
    @GetMapping("slots/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("slot", slotDAO.show(id));
        return "/slots/edit";
    }
    //Update of existing WH button (check for errors and update)
    @PostMapping("slots/{id}")
    public String update(@ModelAttribute("slot") @Valid Slot slot, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "redirect:/slots/{id}/edit";

        slotDAO.update(id, slot);
        return "redirect:/warehouses";
    }
    //Slot deletion button
    @PostMapping("slots/{id}/delete/")
    public String delete(@PathVariable("id") int id) {
        long shelfId = slotDAO.show(id).getShelf().getShelfId();
        String shelfIdText = "/shelves/"+shelfId+"/slots";
        slotDAO.delete(id);
        return "redirect:"+shelfIdText;
    }
}
