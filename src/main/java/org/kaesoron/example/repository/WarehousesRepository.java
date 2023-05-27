package org.kaesoron.example.repository;

import org.kaesoron.example.models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousesRepository extends JpaRepository<Warehouse, Long> {

}
