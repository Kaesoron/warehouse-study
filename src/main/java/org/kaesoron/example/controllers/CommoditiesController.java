package org.kaesoron.example.controllers;

import jakarta.validation.Valid;
import org.kaesoron.example.dao.CommodityDAO;
import org.kaesoron.example.dao.SlotDAO;
import org.kaesoron.example.models.Commodity;
import org.kaesoron.example.models.Slot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping()
public class CommoditiesController {
    private final CommodityDAO commodityDAO;
    private final SlotDAO slotDAO;

    public CommoditiesController(CommodityDAO commodityDAO, SlotDAO slotDAO) {
        this.commodityDAO = commodityDAO;
        this.slotDAO = slotDAO;
    }
    //Total list of commodities
    @GetMapping("/commodities")
    public String index(Model model) {
        model.addAttribute("commodities", commodityDAO.index());
        return "/commodities/index";
    }
    //Total list of commodities with "/" in URL
    @GetMapping("/commodities/")
    public String index2() {
        return "redirect:/commodities";
    }
    //List of commodities at current slot
    @GetMapping("slots/{id}/commodities")
    public String indexSlot(@PathVariable("id") long id, Model model) {
        model.addAttribute("commodities", commodityDAO.indexSlot(id));
        return "/commodities/index";
    }
    //List of commodities of current shelf
    @GetMapping("shelves/{id}/commodities")
    public String indexShelf(@PathVariable("id") long id, Model model) {
        model.addAttribute("commodities", commodityDAO.indexShelf(id));
        return "/commodities/index";
    }
    //List of commodities of current warehouse
    @GetMapping("/{id}/shelves/commodities")
    public String indexWarehouse(@PathVariable("id") long id, Model model) {
        model.addAttribute("commodities", commodityDAO.indexWarehouse(id));
        return "/commodities/index";
    }
    @GetMapping("/{id}/commodities")
    public String indexWarehouse2(@PathVariable("id") long id) {
        return "redirect:/{id}/shelves/commodities";
    }
    //Separate commodity page
    @GetMapping("/commodities/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("commodity", commodityDAO.show(id));
        return "/commodities/show";
    }
    //Creation of new commodity page
    @GetMapping("/commodities/new")
    public String newCommodity(@ModelAttribute("commodity") Commodity commodity, Model model) {
        List<Slot> freeSlots = commodityDAO.getFreeSlots();
        model.addAttribute("freeSlots", freeSlots);
        return "/commodities/new";
    }
    //Button for new commodity save
    @PostMapping("/commodities")
    public String create(@ModelAttribute("commodity") @Valid Commodity commodity,
                         @ModelAttribute("slot") long slot,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/commodities/new";
        }
        commodityDAO.save(commodity, slot);
        slotDAO.setSlotForCommodity(commodity, slot);
        return "/commodities/index";
    }
    //Edit of existing commodity (hyperlink)
    @GetMapping("/commodities/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("commodity", commodityDAO.show(id));
        return "/commodities/edit";
    }
    //Update of existing commodity button (check for errors and update)
    @PostMapping("/commodities/{id}/edit")
    public String update(@ModelAttribute("commodity") @Valid Commodity commodity, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "redirect:/commodities/{id}/edit";
        commodityDAO.update(id, commodity);
        return "redirect:/commodities";
    }
    //Deletion of existing commodity button
    @PostMapping("/commodities/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        commodityDAO.delete(id);
        return "redirect:/commodities";
    }
}
