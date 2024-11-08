package com.example.crud.controller;

import com.example.crud.model.Ship;
import com.example.crud.service.ShipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ships")
public class ShipController {
    @Autowired
    private ShipService shipService;

    @Operation(summary = "Obtener todas las naves", description = "Devuelve una lista paginada de todas las naves espaciales.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de naves devuelta exitosamente"),
        @ApiResponse(responseCode = "400", description = "Parámetros de paginación inválidos")
    })
    @GetMapping
    public Page<Ship> getAllShips(Pageable pageable) {
        return shipService.getAllShips(pageable);
    }

    @Operation(summary = "Obtener una nave por ID", description = "Devuelve una nave espacial por su ID.")
    @Parameter(name = "id", description = "El ID de la nave que deseas obtener", required = true)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Nave encontrada"),
        @ApiResponse(responseCode = "404", description = "Nave no encontrada")
    })
    @GetMapping("/{id}")
    public Ship getShipById(@PathVariable Long id) {
        return shipService.getShipById(id);
    }

    @Operation(summary = "Crear una nueva nave", description = "Permite crear una nueva nave espacial.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Nave creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    @PostMapping
    public Ship createShip(@RequestBody Ship ship) {
        return shipService.createShip(ship);
    }

    @Operation(summary = "Actualizar una nave", description = "Permite actualizar los datos de una nave existente.")
    @Parameter(name = "id", description = "El ID de la nave que deseas actualizar", required = true)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Nave actualizada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Nave no encontrada")
    })
    @PutMapping("/{id}")
    public Ship updateShip(@PathVariable Long id, @RequestBody Ship ship) {
        return shipService.updateShip(id, ship);
    }

    @Operation(summary = "Eliminar una nave", description = "Permite eliminar una nave por su ID.")
    @Parameter(name = "id", description = "El ID de la nave que deseas eliminar", required = true)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Nave eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Nave no encontrada")
    })
    @DeleteMapping("/{id}")
    public void deleteShip(@PathVariable Long id) {
        shipService.deleteShip(id);
    }
}
