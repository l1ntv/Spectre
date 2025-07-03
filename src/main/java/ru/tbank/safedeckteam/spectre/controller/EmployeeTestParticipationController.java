package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.*;
import ru.tbank.safedeckteam.spectre.service.EmployeeTestParticipationService;

import java.util.List;

@RestController
@RequestMapping("/employees-tests-participations")
@RequiredArgsConstructor
public class EmployeeTestParticipationController {

    private final EmployeeTestParticipationService employeeTestParticipationService;

    @GetMapping
    public ResponseEntity<List<EmployeeTestParticipationDTO>> getAllEmployeesTestsParticipations() {
        return ResponseEntity.ok(employeeTestParticipationService.findAllEmployeesTestsParticipations());
    }

    @GetMapping("/{employeeTestParticipationId}")
    public ResponseEntity<EmployeeTestParticipationDTO> getEmployeeTestParticipation(
            @PathVariable Long employeeTestParticipationId) {
        return ResponseEntity
                .ok(employeeTestParticipationService.findEmployeeTestParticipationById(employeeTestParticipationId));
    }

    @PostMapping
    public ResponseEntity<EmployeeTestParticipationDTO> createEmployeeTestParticipation(
            @RequestBody CreatedEmployeeTestParticipationDTO createdEmployeeTestParticipationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeTestParticipationService.createEmployeeTestParticipation(createdEmployeeTestParticipationDTO));
    }

    @PutMapping("/{employeeTestParticipationId}")
    public ResponseEntity<EmployeeTestParticipationDTO> updateEmployeeTestParticipation(
            @RequestBody UpdatedEmployeeTestParticipationDTO updatedEmployeeTestParticipationDTO,
            @PathVariable Long employeeTestParticipationId) {
        return ResponseEntity
                .ok(employeeTestParticipationService.updateEmployeeTestParticipation(
                        updatedEmployeeTestParticipationDTO,
                        employeeTestParticipationId));
    }

    @DeleteMapping("/{employeeTestParticipationId}")
    public ResponseEntity<EmployeeTestParticipationDTO> deleteEmployeeTestParticipation(
            @PathVariable Long employeeTestParticipationId) {
        return ResponseEntity
                .ok(employeeTestParticipationService.deleteEmployeeTestParticipation(employeeTestParticipationId));
    }
}
