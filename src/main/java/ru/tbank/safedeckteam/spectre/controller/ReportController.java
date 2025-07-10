package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.AircraftDTO;
import ru.tbank.safedeckteam.spectre.dto.EmployeeTestParticipationDTO;
import ru.tbank.safedeckteam.spectre.dto.OrganizationDTO;
import ru.tbank.safedeckteam.spectre.dto.ReportOrganizationsByAircraftTestsDTO;
import ru.tbank.safedeckteam.spectre.service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/get-organizations-by-aircraft-tests")
    ResponseEntity<List<ReportOrganizationsByAircraftTestsDTO>> getOrganizationsByAircraftTests(@RequestBody AircraftDTO dto) {
        return ResponseEntity.ok(reportService.findOrganizationsByAircraftTests(dto));
    }

    @PostMapping("/get-employee-test-participation-by-organization")
    ResponseEntity<List<EmployeeTestParticipationDTO>> getEmployeeTestParticipationByOrganization(@RequestBody OrganizationDTO dto) {
        return ResponseEntity.ok(reportService.findEmployeeTestParticipationByOrganization(dto));
    }

    @PostMapping("/get-average-count-test-by-organization")
    ResponseEntity<Double> getAverageCountTestByOrganization(@RequestBody OrganizationDTO dto) {
        return ResponseEntity.ok(reportService.findAverageCountTestByOrganization(dto));
    }
}
