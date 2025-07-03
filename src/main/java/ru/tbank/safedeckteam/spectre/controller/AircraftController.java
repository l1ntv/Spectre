package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.*;
import ru.tbank.safedeckteam.spectre.service.AircraftService;

import java.util.List;

@RestController
@RequestMapping("/aircrafts")
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftService aircraftService;

    @GetMapping
    public ResponseEntity<List<AircraftDTO>> getAllAircrafts() {
        return ResponseEntity.ok(aircraftService.findAllAircrafts());
    }

    @GetMapping("/{aircraftId}")
    public ResponseEntity<AircraftDTO> getAircraft(@PathVariable Long aircraftId) {
        return ResponseEntity.ok(aircraftService.findAircraftById(aircraftId));
    }

    @PostMapping
    public ResponseEntity<AircraftDTO> createAircraft(@RequestBody CreatedAircraftDTO createdAircraftDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(aircraftService.createAircraft(createdAircraftDTO));
    }

    @PutMapping("/{aircraftId}")
    public ResponseEntity<AircraftDTO> updateAircraft(@RequestBody UpdatedAircraftDTO updatedAircraftDTO,
                                                      @PathVariable Long aircraftId) {
        return ResponseEntity.ok(aircraftService.updateAircraft(updatedAircraftDTO, aircraftId));
    }

    @DeleteMapping("/{aircraftId}")
    public ResponseEntity<AircraftDTO> deleteAircraft(@PathVariable Long aircraftId) {
        return ResponseEntity.ok(aircraftService.deleteAircraft(aircraftId));
    }
}
