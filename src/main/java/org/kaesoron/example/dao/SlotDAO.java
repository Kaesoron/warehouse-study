package org.kaesoron.example.dao;

import org.kaesoron.example.models.Slot;
import org.kaesoron.example.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class SlotDAO {

    @Autowired
    private SlotRepository slotRepository;

    public List<Slot> index(long id) {
        return (slotRepository.findAll().stream().filter(slot -> slot.getShelf().getShelfId() == id)).toList();
    }

    public Slot show(long id) {
        return slotRepository.getReferenceById(id);
    }
    @Transactional
    public void save(Slot slot) {
        slotRepository.save(slot);
    }
    @Transactional
    public void update(int id, Slot slot) {
        Slot toBeUpdated = show(id);
        toBeUpdated.setCommodity(slot.getCommodity());
    }
    @Transactional
    public void delete(long id) {
        slotRepository.delete(Objects.requireNonNull(slotRepository.getReferenceById(id)));
    }
}
