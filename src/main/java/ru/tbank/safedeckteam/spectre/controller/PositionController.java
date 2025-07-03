package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.*;
import ru.tbank.safedeckteam.spectre.service.PositionService;

import java.util.List;

@RestController
@RequestMapping("/positions")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @GetMapping
    public ResponseEntity<List<PositionDTO>> getAllPositions() {
        return ResponseEntity.ok(positionService.findAllPositions());
    }

    @GetMapping("/{positionId}")
    public ResponseEntity<PositionDTO> getPosition(@PathVariable Long positionId) {
        return ResponseEntity.ok(positionService.findPositionById(positionId));
    }

    @PostMapping
    public ResponseEntity<PositionDTO> createPosition(@RequestBody CreatedPositionDTO createdPositionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(positionService.createPosition(createdPositionDTO));
    }

    @PatchMapping("/{positionId}")
    public ResponseEntity<PositionDTO> renamePosition(@RequestBody RenamedPositionDTO renamedPositionDTO,
                                                      @PathVariable Long positionId) {
        return ResponseEntity.ok(positionService.renamePosition(renamedPositionDTO, positionId));
    }

    @DeleteMapping("/{positionId}")
    public ResponseEntity<PositionDTO> deletePosition(@PathVariable Long positionId) {
        return ResponseEntity.ok(positionService.deletePosition(positionId));
    }
}
