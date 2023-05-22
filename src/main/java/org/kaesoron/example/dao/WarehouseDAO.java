package org.kaesoron.example.dao;

import org.kaesoron.example.models.Warehouse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WarehouseDAO {
    private static List<Warehouse> warehouses;
    private static int whCount;

    {
        warehouses = new ArrayList<>();
        warehouses.add(new Warehouse(++whCount, "First WH", "First test"));
        warehouses.add(new Warehouse(++whCount, "Second WH", "First test"));
        warehouses.add(new Warehouse(++whCount, "Third WH", "First test"));
    }

    public List<Warehouse> index() {
        return warehouses;
    }

    public Warehouse show(int id) {
        return warehouses.stream().filter(warehouse -> warehouse.getWarehouseId()==id).findAny().orElse(null);
    }

    public static void save(Warehouse warehouse) {
        warehouse.setWarehouseId(++whCount);
        warehouses.add(warehouse);
    }
}
