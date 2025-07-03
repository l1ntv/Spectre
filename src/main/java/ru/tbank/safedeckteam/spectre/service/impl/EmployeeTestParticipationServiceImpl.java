package ru.tbank.safedeckteam.spectre.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tbank.safedeckteam.spectre.dto.CreatedEmployeeTestParticipationDTO;
import ru.tbank.safedeckteam.spectre.dto.EmployeeTestParticipationDTO;
import ru.tbank.safedeckteam.spectre.dto.UpdatedEmployeeTestParticipationDTO;
import ru.tbank.safedeckteam.spectre.exception.ResourceNotFoundException;
import ru.tbank.safedeckteam.spectre.mapper.EmployeeTestParticipationMapper;
import ru.tbank.safedeckteam.spectre.model.EmployeeTestParticipation;
import ru.tbank.safedeckteam.spectre.repository.EmployeeRepository;
import ru.tbank.safedeckteam.spectre.repository.EmployeeTestParticipationRepository;
import ru.tbank.safedeckteam.spectre.repository.TestRepository;
import ru.tbank.safedeckteam.spectre.service.EmployeeTestParticipationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeTestParticipationServiceImpl implements EmployeeTestParticipationService {

    private final EmployeeTestParticipationRepository employeeTestParticipationRepository;

    private final EmployeeTestParticipationMapper employeeTestParticipationMapper;

    private final EmployeeRepository employeeRepository;

    private final TestRepository testRepository;

    @Override
    public List<EmployeeTestParticipationDTO> findAllEmployeesTestsParticipations() {
        return employeeTestParticipationMapper.toDtoList(employeeTestParticipationRepository.findAll());
    }

    @Override
    public EmployeeTestParticipationDTO findEmployeeTestParticipationById(Long id) {
        return employeeTestParticipationMapper.toDto(employeeTestParticipationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee test participation not found.")));
    }

    @Override
    public EmployeeTestParticipationDTO createEmployeeTestParticipation(CreatedEmployeeTestParticipationDTO dto) {
        return employeeTestParticipationMapper.toDto(
                employeeTestParticipationRepository.save(
                        EmployeeTestParticipation.builder()
                                .employee(employeeRepository.findById(dto.getEmployee().getId())
                                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found.")
                                        ))
                                .test(testRepository.findById(dto.getTest().getId())
                                        .orElseThrow(() -> new ResourceNotFoundException("Test not found.")))
                                .role(dto.getRole())
                                .notes(dto.getNotes())
                                .build()
                )
        );
    }

    @Override
    public EmployeeTestParticipationDTO updateEmployeeTestParticipation(UpdatedEmployeeTestParticipationDTO dto, Long id) {
        EmployeeTestParticipation employeeTestParticipation = employeeTestParticipationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee test participation not found."));
        employeeTestParticipation.setEmployee(employeeRepository.findById(dto.getEmployee().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found.")));
        employeeTestParticipation.setTest(testRepository.findById(dto.getTest().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Test not found.")));
        employeeTestParticipation.setRole(dto.getRole());
        employeeTestParticipation.setNotes(dto.getNotes());
        return employeeTestParticipationMapper.toDto(employeeTestParticipationRepository.save(employeeTestParticipation));
    }

    @Override
    public EmployeeTestParticipationDTO deleteEmployeeTestParticipation(Long id) {
        EmployeeTestParticipation employeeTestParticipation = employeeTestParticipationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee test participation not found."));
        employeeTestParticipationRepository.delete(employeeTestParticipation);
        return employeeTestParticipationMapper.toDto(employeeTestParticipation);
    }
}
