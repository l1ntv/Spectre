package ru.tbank.safedeckteam.spectre.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tbank.safedeckteam.spectre.dto.AircraftDTO;
import ru.tbank.safedeckteam.spectre.dto.EmployeeTestParticipationDTO;
import ru.tbank.safedeckteam.spectre.dto.OrganizationDTO;
import ru.tbank.safedeckteam.spectre.dto.ReportOrganizationsByAircraftTestsDTO;
import ru.tbank.safedeckteam.spectre.exception.ResourceNotFoundException;
import ru.tbank.safedeckteam.spectre.mapper.EmployeeTestParticipationMapper;
import ru.tbank.safedeckteam.spectre.model.*;
import ru.tbank.safedeckteam.spectre.repository.AircraftRepository;
import ru.tbank.safedeckteam.spectre.repository.OrganizationRepository;
import ru.tbank.safedeckteam.spectre.service.ReportService;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final AircraftRepository aircraftRepository;

    private final OrganizationRepository organizationRepository;

    private final EmployeeTestParticipationMapper employeeTestParticipationMapper;

    @Override
    public List<ReportOrganizationsByAircraftTestsDTO> findOrganizationsByAircraftTests(AircraftDTO dto) {
        Aircraft aircraft = aircraftRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found."));
        List<ReportOrganizationsByAircraftTestsDTO> reportOrganizationsByAircraftTestsDTOs = new ArrayList<>();
        for (Test test : aircraft.getTests()) {
            Organization organization = test.getOrganization();
            ReportOrganizationsByAircraftTestsDTO report = new ReportOrganizationsByAircraftTestsDTO(
                    organization.getId(),
                    organization.getName(),
                    test.getDate()
            );
            reportOrganizationsByAircraftTestsDTOs.add(report);
        }
        return reportOrganizationsByAircraftTestsDTOs;
    }

    @Override
    public List<EmployeeTestParticipationDTO> findEmployeeTestParticipationByOrganization(OrganizationDTO dto) {
        Organization organization = organizationRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found."));

        List<Test> tests = organization.getTests();
        List<EmployeeTestParticipationDTO> result = new ArrayList<>();

        for (Test test : tests) {
            for (EmployeeTestParticipation participation : test.getParticipations()) {
                result.add(employeeTestParticipationMapper.toDto(participation));
            }
        }

        return result;
    }

    @Override
    public Double findAverageCountTestByOrganization(OrganizationDTO dto) {
        Organization organization = organizationRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found."));
        List<Test> tests = organization.getTests();
        if (tests == null || tests.isEmpty())
            return 0.0;

        List<LocalDate> testDates = tests.stream()
                .map(Test::getDate)
                .sorted()
                .toList();

        if (testDates.isEmpty()) {
            return 0.0;
        }

        YearMonth start = YearMonth.from(testDates.get(0));
        YearMonth end = YearMonth.from(testDates.get(testDates.size() - 1));
        long monthsBetween = ChronoUnit.MONTHS.between(start, end) + 1;
        double averagePerMonth = (double) tests.size() / monthsBetween;
        return averagePerMonth;
    }

    private boolean belongsToOrganization(Employee employee, Organization targetOrg) {
        return employee.getEmployeePositionHistories().stream()
                .anyMatch(history -> {
                    Unit unit = history.getUnit();
                    return unit != null &&
                            unit.getOrganization() != null &&
                            unit.getOrganization().getId().equals(targetOrg.getId());
                });
    }
}
