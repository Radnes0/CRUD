package com.example.crud.service;

import com.example.crud.model.Ship;
import com.example.crud.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {
    @Autowired
    private ShipRepository shipRepository;

    public Page<Ship> getAllShips(Pageable pageable) {
        return shipRepository.findAll(pageable);
    }

    public Ship getShipById(Long id) {
        return shipRepository.findById(id).orElseThrow(() -> new RuntimeException("Ship not found"));
    }

    public List<Ship> searchShipsByName(String name) {
        return shipRepository.findByNameContaining(name);
    }

    public Ship createShip(Ship ship) {
        return shipRepository.save(ship);
    }

    public Ship updateShip(Long id, Ship updatedShip) {
        Ship ship = getShipById(id);
        ship.setName(updatedShip.getName());
        ship.setModel(updatedShip.getModel());
        ship.setSeries(updatedShip.getSeries());
        return shipRepository.save(ship);
    }

    public void deleteShip(Long id) {
        shipRepository.deleteById(id);
    }
}
