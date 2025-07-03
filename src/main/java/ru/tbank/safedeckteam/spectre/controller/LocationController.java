package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.CreatedLocationDTO;
import ru.tbank.safedeckteam.spectre.dto.LocationDTO;
import ru.tbank.safedeckteam.spectre.dto.UpdatedLocationDTO;
import ru.tbank.safedeckteam.spectre.service.LocationsService;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationsService locationsService;

    @GetMapping
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        return ResponseEntity.ok(locationsService.findAllLocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable Long id) {
        return ResponseEntity.ok(locationsService.findLocationById(id));
    }

    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@RequestBody CreatedLocationDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(locationsService.createLocation(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationDTO> updateLocation(@RequestBody UpdatedLocationDTO dto,
                                                      @PathVariable Long id) {
        return ResponseEntity.ok(locationsService.updateLocation(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LocationDTO> deleteLocation(@PathVariable Long id) {
        return ResponseEntity.ok(locationsService.deleteLocation(id));
    }
}
