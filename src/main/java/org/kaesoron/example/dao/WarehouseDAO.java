package org.kaesoron.example.dao;

import org.kaesoron.example.models.Warehouse;
import org.kaesoron.example.repository.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WarehouseDAO {

    @Autowired
    private WarehousesRepository warehousesRepository;

    @Autowired
    public List<Warehouse> index() {
        return warehousesRepository.findAll();
    }

    public Warehouse show(long id) {
        return warehousesRepository.findById(id).orElse(null);
    }

    public void save(Warehouse warehouse) {
        warehousesRepository.save(warehouse);
    }

    public void update(int id, Warehouse warehouse) {
        Warehouse toBeUpdated = show(id);
        toBeUpdated.setWarehouseName(warehouse.getWarehouseName());
        toBeUpdated.setWarehouseDescription(warehouse.getWarehouseDescription());
    }

    public void delete(long id) {
        warehousesRepository.delete(Objects.requireNonNull(warehousesRepository.findById(id).orElse(null)));
    }
}
