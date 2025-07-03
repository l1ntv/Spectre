package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.*;
import ru.tbank.safedeckteam.spectre.service.EmployeePositionHistoryService;

import java.util.List;

@RestController
@RequestMapping("/employees-positions-history")
@RequiredArgsConstructor
public class EmployeePositionHistoryController {

    private final EmployeePositionHistoryService employeePositionHistoryService;

    @GetMapping
    public ResponseEntity<List<EmployeePositionHistoryDTO>> getAllEmployeesPositionsHistories() {
        return ResponseEntity
                .ok(employeePositionHistoryService.findAllEmployeesPositionsHistories());
    }

    @GetMapping("/{employeePositionHistoryId}")
    public ResponseEntity<EmployeePositionHistoryDTO> getEmployeePositionHistory(
            @PathVariable Long employeePositionHistoryId) {
        return ResponseEntity
                .ok(employeePositionHistoryService.findEmployeePositionHistory(
                        employeePositionHistoryId));
    }

    @PostMapping
    public ResponseEntity<EmployeePositionHistoryDTO> createEmployeePositionHistory(
            @RequestBody CreatedEmployeePositionHistoryDTO createdEmployeePositionHistoryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeePositionHistoryService.createEmployeePositionHistory(
                        createdEmployeePositionHistoryDTO));
    }

    @PutMapping("/{employeePositionHistoryId}")
    public ResponseEntity<EmployeePositionHistoryDTO> updateEmployeePositionHistory(
            @RequestBody UpdatedEmployeePositionHistoryDTO updatedEmployeePositionHistoryDTO,
            @PathVariable Long employeePositionHistoryId) {
        return ResponseEntity.ok(employeePositionHistoryService.updateEmployeePositionHistory(
                updatedEmployeePositionHistoryDTO,
                employeePositionHistoryId));
    }

    @DeleteMapping("/{employeePositionHistoryId}")
    public ResponseEntity<EmployeePositionHistoryDTO> deleteEmployeePositionHistory(
            @PathVariable Long employeePositionHistoryId) {
        return ResponseEntity.ok(employeePositionHistoryService.deleteEmployeePositionHistory(
                employeePositionHistoryId));
    }
}
