package org.kaesoron.example.repository;

import org.kaesoron.example.models.Shelf;
import org.kaesoron.example.models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelvesRepository extends JpaRepository<Shelf, Long> {

}
