package ru.tbank.safedeckteam.spectre.service;

import ru.tbank.safedeckteam.spectre.dto.AircraftDTO;
import ru.tbank.safedeckteam.spectre.dto.EmployeeTestParticipationDTO;
import ru.tbank.safedeckteam.spectre.dto.OrganizationDTO;
import ru.tbank.safedeckteam.spectre.dto.ReportOrganizationsByAircraftTestsDTO;

import java.util.List;

public interface ReportService {

    List<ReportOrganizationsByAircraftTestsDTO> findOrganizationsByAircraftTests(AircraftDTO dto);

    List<EmployeeTestParticipationDTO> findEmployeeTestParticipationByOrganization(OrganizationDTO dto);

    Double findAverageCountTestByOrganization(OrganizationDTO dto);
}
