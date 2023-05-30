package org.kaesoron.example.dao;

import org.kaesoron.example.models.Warehouse;
import org.kaesoron.example.repository.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void save(Warehouse warehouse) {
        warehousesRepository.save(warehouse);
    }
    @Transactional
    public void update(long id, Warehouse warehouse) {
        Warehouse toBeUpdated = warehousesRepository.getReferenceById(id);
        toBeUpdated.setWarehouseName(warehouse.getWarehouseName());
        toBeUpdated.setWarehouseDescription(warehouse.getWarehouseDescription());
        warehousesRepository.save(toBeUpdated);
    }
    @Transactional
    public void delete(long id) {
        warehousesRepository.delete(Objects.requireNonNull(warehousesRepository.findById(id).orElse(null)));
    }
}
