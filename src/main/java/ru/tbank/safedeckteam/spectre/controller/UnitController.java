package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.*;
import ru.tbank.safedeckteam.spectre.service.UnitService;

import java.util.List;

@RestController
@RequestMapping("/units")
@RequiredArgsConstructor
public class UnitController {

    private final UnitService unitService;

    @GetMapping
    public ResponseEntity<List<UnitDTO>> getAllUnits() {
        return ResponseEntity.ok(unitService.findAllUnits());
    }

    @GetMapping("/{unitId}")
    public ResponseEntity<UnitDTO> getUnit(@PathVariable Long unitId) {
        return ResponseEntity.ok(unitService.findUnitById(unitId));
    }

    @PostMapping
    public ResponseEntity<UnitDTO> createUnit(@RequestBody CreatedUnitDTO createdUnitDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(unitService.createUnit(createdUnitDTO));
    }

    @PutMapping("/{unitId}")
    public ResponseEntity<UnitDTO> updateUnit(@RequestBody UpdatedUnitDTO updatedUnitDTO,
                                              @PathVariable Long unitId) {
        return ResponseEntity.ok(unitService.updateUnit(updatedUnitDTO, unitId));
    }

    @DeleteMapping("/{unitId}")
    public ResponseEntity<UnitDTO> deleteUnit(@PathVariable Long unitId) {
        return ResponseEntity.ok(unitService.deleteUnit(unitId));
    }
}
