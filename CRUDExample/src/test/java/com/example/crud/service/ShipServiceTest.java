package com.example.crud.service;

import com.example.crud.controller.ShipController;
import com.example.crud.model.Ship;
import com.example.crud.service.ShipService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ShipController.class, excludeAutoConfiguration = {org.springdoc.webmvc.api.OpenApiWebMvcResource.class})
class ShipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShipService shipService;

    @Test
    void testGetAllShips() throws Exception {
        Ship ship1 = new Ship(1L, "Millennium Falcon", "Star Wars", "YT-1300");
        Ship ship2 = new Ship(2L, "USS Enterprise", "Star Trek", "NCC-1701");

        Pageable pageable = PageRequest.of(0, 5);
        Page<Ship> page = new PageImpl<>(Arrays.asList(ship1, ship2), pageable, 2);

        when(shipService.getAllShips(any(Pageable.class))).thenReturn(page);

        mockMvc.perform(get("/api/ships?page=0&size=5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"content\":[{\"name\":\"Millennium Falcon\"},{\"name\":\"USS Enterprise\"}],\"totalElements\":2}"));
    }

    @Test
    void testGetShipById() throws Exception {
        Ship ship = new Ship(1L, "Millennium Falcon", "Star Wars", "YT-1300");
        when(shipService.getShipById(1L)).thenReturn(ship);

        mockMvc.perform(get("/api/ships/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"Millennium Falcon\",\"series\":\"Star Wars\"}"));
    }
}