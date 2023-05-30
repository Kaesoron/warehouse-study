package org.kaesoron.example.dao;

import org.kaesoron.example.models.Commodity;
import org.kaesoron.example.models.Shelf;
import org.kaesoron.example.models.Slot;
import org.kaesoron.example.repository.CommodityRepository;
import org.kaesoron.example.repository.ShelvesRepository;
import org.kaesoron.example.repository.SlotRepository;
import org.kaesoron.example.repository.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CommodityDAO {

    @Autowired
    private CommodityRepository commodityRepository;
    @Autowired
    private SlotRepository slotRepository;
    @Autowired
    private ShelvesRepository shelvesRepository;
    @Autowired
    private WarehousesRepository warehousesRepository;

    public List<Commodity> index() {
        return commodityRepository.findAll();
    }

    public Commodity indexSlot(long id) {
        return slotRepository.getReferenceById(id).getCommodity();
    }

    public List<Commodity> indexShelf(long id) {
        List<Slot> slots = shelvesRepository.getReferenceById(id).getSlots();
        List<Commodity> commodities = new ArrayList<>();
        for (Slot slot : slots) {
            commodities.add(slot.getCommodity());
        }
        return commodities;
    }

    public List<Commodity> indexWarehouse(long id) {
        List<Shelf> shelves = warehousesRepository.getReferenceById(id).getShelves();
        List<Slot> slots = new ArrayList<>();
        for (Shelf shelf : shelves) {
            slots.addAll(shelf.getSlots());
        }
        List<Commodity> commodities = new ArrayList<>();
        for (Slot slot : slots) {
            commodities.add(slot.getCommodity());
        }
        return commodities;
    }

    public Commodity show(long id) {
        return commodityRepository.findById(id).orElse(null);
    }

    public void save(Commodity commodity) {
        commodityRepository.save(commodity);
    }

    public void update(int id, Commodity commodity) {
        Commodity toBeUpdated = show(id);
        toBeUpdated.getSlot().setEmpty(true);
        toBeUpdated.setCommodityName(commodity.getCommodityName());
        toBeUpdated.setDescription(commodity.getDescription());
        toBeUpdated.setSlot(commodity.getSlot());
    }

    public void delete(long id) {
        commodityRepository.delete(Objects.requireNonNull(commodityRepository.getReferenceById(id)));
    }

    public List<Slot> getFreeSlots() {
        return slotRepository.findAll().stream().filter(slot -> slot.isEmpty()).toList();
    }

    public void setSlotAvailable(Commodity commodity){
        commodity.getSlot().setEmpty(true);
    }

    public void setSlotNotAvailable(Commodity commodity){
        commodity.getSlot().setEmpty(false);
    }
}
