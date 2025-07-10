package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/get-organizations-by-aircraft-tests")
    ResponseEntity<List<ReportOrganizationsByAircraftTestsDTO>> getOrganizationsByAircraftTests(AircraftDTO dto) {
        return ResponseEntity.ok(reportService.findOrganizationsByAircraftTests(dto));
    }

    @GetMapping("/get-employee-test-participation-by-organization")
    ResponseEntity<List<EmployeeTestParticipationDTO>> getEmployeeTestParticipationByOrganization(OrganizationDTO dto) {
        return ResponseEntity.ok(reportService.findEmployeeTestParticipationByOrganization(dto));
    }

    @GetMapping("/get-average-count-test-by-organization")
    ResponseEntity<Double> getAverageCountTestByOrganization(OrganizationDTO dto) {
        return ResponseEntity.ok(reportService.findAverageCountTestByOrganization(dto));
    }
}
