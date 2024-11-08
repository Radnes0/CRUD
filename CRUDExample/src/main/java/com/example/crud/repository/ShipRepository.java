package com.example.crud.repository;

import com.example.crud.model.Ship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    Page<Ship> findAll(Pageable pageable);
    List<Ship> findByNameContaining(String name);
}
