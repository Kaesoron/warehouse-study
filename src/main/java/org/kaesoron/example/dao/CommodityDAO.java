package org.kaesoron.example.dao;

import org.kaesoron.example.models.*;
import org.kaesoron.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return commodityRepository.findAll().stream().filter(Commodity::isPresent).toList();
    }

    public Commodity indexSlot(long id) {
        if (!slotRepository.getReferenceById(id).isEmpty()) {
            return slotRepository.getReferenceById(id).getCommodity();
        } else return null;
    }

    public List<Commodity> indexShelf(long id) {
        List<Slot> slots = shelvesRepository.getReferenceById(id).getSlots();
        List<Commodity> commodities = new ArrayList<>();
        for (Slot slot : slots) {
            Commodity commodity = slot.getCommodity();
            if (commodity!=null && commodity.isPresent()){
                commodities.add(slot.getCommodity());
            }
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
            Commodity commodity = slot.getCommodity();
            if (commodity!=null && commodity.isPresent()){
                commodities.add(slot.getCommodity());
            }
        }
        return commodities;
    }

    public Commodity show(long id) {
        return commodityRepository.findById(id).orElse(null);
    }
    @Transactional
    public void save(Commodity commodity) {
        commodity.setPresent(true);
        commodityRepository.save(commodity);
        journalRepository.save(new Journal(INCOMING, commodity.getCommodityName()));
    }
    @Transactional
    public void update(long id, Commodity commodity) {
        Commodity toBeUpdated = show(id);
        toBeUpdated.setCommodityName(commodity.getCommodityName());
        toBeUpdated.setDescription(commodity.getDescription());
        journalRepository.save(new Journal(UPDATE, show(id).getCommodityName()+" NAME CHANGED TO: "+Objects.requireNonNull(commodityRepository.getReferenceById(id)).getCommodityName()));
        commodityRepository.save(toBeUpdated);
    }
    @Transactional
    public void delete(long id) {
        Slot slot = commodityRepository.getReferenceById(id).getSlot();
        slot.setEmpty(true);
        slot.setCommodity(null);
        slotRepository.save(slot);
        commodityRepository.getReferenceById(id).setPresent(false);
        commodityRepository.getReferenceById(id).setSlot(null);
        journalRepository.save(new Journal(OUTCOMING, Objects.requireNonNull(commodityRepository.getReferenceById(id)).getCommodityName()));
    }
    @Transactional
    public List<Slot> getFreeSlots() {
        return slotRepository.findAll().stream().filter(Slot::isEmpty).toList();
    }
}
