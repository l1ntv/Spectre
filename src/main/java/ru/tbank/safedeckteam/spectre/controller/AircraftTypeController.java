package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.*;
import ru.tbank.safedeckteam.spectre.service.AircraftTypeService;

import java.util.List;

@RestController
@RequestMapping("/aircraft-types")
@RequiredArgsConstructor
public class AircraftTypeController {

    private final AircraftTypeService aircraftTypeService;

    @GetMapping
    public ResponseEntity<List<AircraftTypeDTO>> getAllAircraftTypes() {
        return ResponseEntity.ok(aircraftTypeService.findAllAircraftTypes());
    }

    @GetMapping("/{aircraftTypeId}")
    public ResponseEntity<AircraftTypeDTO> getAircraftType(@PathVariable Long aircraftTypeId) {
        return ResponseEntity.ok(aircraftTypeService.findAircraftTypeById(aircraftTypeId));
    }

    @PostMapping
    public ResponseEntity<AircraftTypeDTO> createAircraftType(@RequestBody CreatedAircraftTypeDTO createdAircraftTypeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(aircraftTypeService.createAircraftType(createdAircraftTypeDTO));
    }

    @PatchMapping("/{aircraftTypeId}")
    public ResponseEntity<AircraftTypeDTO> renamePosition(@RequestBody RenamedAircraftTypeDTO renamedAircraftTypeDTO,
                                                          @PathVariable Long aircraftTypeId) {
        return ResponseEntity.ok(aircraftTypeService.renameAircraftType(renamedAircraftTypeDTO, aircraftTypeId));
    }

    @DeleteMapping("/{aircraftTypeId}")
    public ResponseEntity<AircraftTypeDTO> deletePosition(@PathVariable Long aircraftTypeId) {
        return ResponseEntity.ok(aircraftTypeService.deleteAircraftType(aircraftTypeId));
    }
}
