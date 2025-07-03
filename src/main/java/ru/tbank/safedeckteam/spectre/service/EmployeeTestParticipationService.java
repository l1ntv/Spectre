package ru.tbank.safedeckteam.spectre.service;

import ru.tbank.safedeckteam.spectre.dto.*;

import java.util.List;

public interface EmployeeTestParticipationService {

    List<EmployeeTestParticipationDTO> findAllEmployeesTestsParticipations();

    EmployeeTestParticipationDTO findEmployeeTestParticipationById(Long id);

    EmployeeTestParticipationDTO createEmployeeTestParticipation(CreatedEmployeeTestParticipationDTO dto);

    EmployeeTestParticipationDTO updateEmployeeTestParticipation(UpdatedEmployeeTestParticipationDTO dto, Long id);

    EmployeeTestParticipationDTO deleteEmployeeTestParticipation(Long id);
}
