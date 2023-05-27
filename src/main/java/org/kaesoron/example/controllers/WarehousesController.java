package org.kaesoron.example.controllers;

import jakarta.validation.Valid;
import org.kaesoron.example.dao.WarehouseDAO;
import org.kaesoron.example.models.Warehouse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/warehouses")
public class WarehousesController {

    private final WarehouseDAO warehouseDAO;

    public WarehousesController(WarehouseDAO warehouseDAO) {
        this.warehouseDAO = warehouseDAO;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("warehouses", warehouseDAO.index());
        return "/warehouses/index";
    }

    @GetMapping("/")
    public String index2() {
        return "redirect:/warehouses";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("warehouse", warehouseDAO.show(id));
        return "/warehouses/show";
    }

    @GetMapping("/new")
    public String newWarehouse(@ModelAttribute("warehouse") Warehouse warehouse) {
        return "/warehouses/new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("warehouse") @Valid Warehouse warehouse,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/warehouses/new";
        }

        warehouseDAO.save(warehouse);
        return "redirect:/warehouses";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("warehouse", warehouseDAO.show(id));
        return "/warehouses/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("warehouse") @Valid Warehouse warehouse, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "redirect:/warehouses/{id}/edit";

        warehouseDAO.update(id, warehouse);
        return "redirect:/warehouses";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        warehouseDAO.delete(id);
        return "redirect:/warehouses";
    }
}
