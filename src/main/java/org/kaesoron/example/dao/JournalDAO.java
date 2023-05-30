package org.kaesoron.example.dao;

import org.kaesoron.example.models.Journal;
import org.kaesoron.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalDAO {
    @Autowired
    private JournalRepository journalRepository;
    public List<Journal> index() {
        return journalRepository.findAll();
    }

}
