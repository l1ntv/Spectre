package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.*;

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
    public ResponseEntity<PositionDTO> getAircraftType(@PathVariable Long aircraftTypeId) {
        return ResponseEntity.ok(aircraftTypeService.findAircraftTypeById(aircraftTypeId));
    }

    @PostMapping
    public ResponseEntity<PositionDTO> createAircraftType(@RequestBody CreatedAircraftTypeDTO createdAircraftTypeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(aircraftTypeService.createPosition(createdPositionDTO));
    }

    @PatchMapping("/{aircraftTypeId}")
    public ResponseEntity<PositionDTO> renamePosition(@RequestBody RenamedAircraftTypeDTO renamedAircraftTypeDTO,
                                                      @PathVariable Long aircraftTypeId) {
        return ResponseEntity.ok(aircraftTypeService.renamePosition(renamedPositionDTO, positionId));
    }

    @DeleteMapping("/{positionId}")
    public ResponseEntity<PositionDTO> deletePosition(@PathVariable Long positionId) {
        return ResponseEntity.ok(aircraftTypeService.deletePosition(positionId));
    }

}
