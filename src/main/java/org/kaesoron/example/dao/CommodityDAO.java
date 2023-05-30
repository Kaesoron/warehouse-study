package org.kaesoron.example.dao;

import org.kaesoron.example.models.*;
import org.kaesoron.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.kaesoron.example.models.OperationType.*;

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
    @Autowired
    private JournalRepository journalRepository;

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
        journalRepository.save(new Journal(INCOMING, commodity));
    }

    public void update(long id, Commodity commodity) {
        Commodity toBeUpdated = show(id);
        toBeUpdated.getSlot().setEmpty(true);
        toBeUpdated.setCommodityName(commodity.getCommodityName());
        toBeUpdated.setDescription(commodity.getDescription());
        toBeUpdated.setSlot(commodity.getSlot());
        journalRepository.save(new Journal(UPDATE, Objects.requireNonNull(commodityRepository.getReferenceById(id))));
    }

    public void delete(long id) {
        journalRepository.save(new Journal(OUTCOMING, Objects.requireNonNull(commodityRepository.getReferenceById(id))));
        slotRepository.getReferenceById(commodityRepository.getReferenceById(id).getSlot().getSlotId()).setEmpty(true);
        commodityRepository.delete(Objects.requireNonNull(commodityRepository.getReferenceById(id)));
    }

    public List<Slot> getFreeSlots() {
        return slotRepository.findAll().stream().filter(slot -> slot.isEmpty()).toList();
    }
}
