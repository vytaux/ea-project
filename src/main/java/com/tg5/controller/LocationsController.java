package com.tg5.controller;

import com.tg5.domain.Location;
import com.tg5.repository.LocationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    private final LocationRepository locationRepository;

    public LocationsController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    // TODO locations CRUD
    @GetMapping
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }
}
