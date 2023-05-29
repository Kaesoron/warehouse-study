package org.kaesoron.example.dao;

import org.kaesoron.example.models.Shelf;
import org.kaesoron.example.repository.ShelvesRepository;
import org.kaesoron.example.repository.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ShelfDAO {

    @Autowired
    private ShelvesRepository shelvesRepository;

    @Autowired
    private WarehousesRepository warehousesRepository;

    public List<Shelf> index(long id) {
        return (shelvesRepository.findAll().stream().filter(shelf -> shelf.getWarehouse().getWarehouseId() == id)).toList();
    }

    public Shelf show(long id) {
        return shelvesRepository.getReferenceById(id);
    }

    public void save(Shelf shelf) {
        shelvesRepository.save(shelf);
    }

    public void delete(long id) {
        shelvesRepository.delete(Objects.requireNonNull(shelvesRepository.getReferenceById(id)));
    }
}
