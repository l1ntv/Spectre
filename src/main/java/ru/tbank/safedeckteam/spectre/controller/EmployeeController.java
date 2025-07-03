package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.*;
import ru.tbank.safedeckteam.spectre.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.findEmployeeById(employeeId));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody CreatedEmployeeDTO createdEmployeeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(createdEmployeeDTO));
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody UpdatedEmployeeDTO updatedEmployeeDTO,
                                                      @PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployee(updatedEmployeeDTO, employeeId));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.deleteEmployee(employeeId));
    }
}
