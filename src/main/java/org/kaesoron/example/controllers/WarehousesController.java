package org.kaesoron.example.controllers;

import org.kaesoron.example.dao.WarehouseDAO;
import org.kaesoron.example.models.Warehouse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("warehouse", warehouseDAO.show(id));
        return "/warehouses/show";
    }

    @GetMapping("/new")
    public String newWarehouse(Model model) {
        model.addAttribute("warehouse", new Warehouse());
        return "/warehouses/new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("warehouse") Warehouse warehouse) {
        WarehouseDAO.save(warehouse);
        return "redirect:/warehouses";
    }
}
