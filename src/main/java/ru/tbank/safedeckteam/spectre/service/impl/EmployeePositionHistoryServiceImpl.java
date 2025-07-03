package ru.tbank.safedeckteam.spectre.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tbank.safedeckteam.spectre.dto.CreatedEmployeePositionHistoryDTO;
import ru.tbank.safedeckteam.spectre.dto.EmployeePositionHistoryDTO;
import ru.tbank.safedeckteam.spectre.dto.UpdatedEmployeePositionHistoryDTO;
import ru.tbank.safedeckteam.spectre.exception.ResourceNotFoundException;
import ru.tbank.safedeckteam.spectre.mapper.EmployeePositionHistoryMapper;
import ru.tbank.safedeckteam.spectre.model.EmployeePositionHistory;
import ru.tbank.safedeckteam.spectre.repository.EmployeePositionHistoryRepository;
import ru.tbank.safedeckteam.spectre.repository.EmployeeRepository;
import ru.tbank.safedeckteam.spectre.repository.PositionRepository;
import ru.tbank.safedeckteam.spectre.repository.UnitRepository;
import ru.tbank.safedeckteam.spectre.service.EmployeePositionHistoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeePositionHistoryServiceImpl implements EmployeePositionHistoryService {

    private final EmployeePositionHistoryRepository employeePositionHistoryRepository;

    private final EmployeePositionHistoryMapper employeePositionHistoryMapper;

    private final EmployeeRepository employeeRepository;

    private final PositionRepository positionRepository;

    private final UnitRepository unitRepository;

    @Override
    public List<EmployeePositionHistoryDTO> findAllEmployeesPositionsHistories() {
        return employeePositionHistoryMapper.toDtoList(employeePositionHistoryRepository.findAll());
    }

    @Override
    public EmployeePositionHistoryDTO findEmployeePositionHistory(Long id) {
        return employeePositionHistoryMapper.toDto(
                employeePositionHistoryRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee position history not found."))
        );
    }

    @Override
    public EmployeePositionHistoryDTO createEmployeePositionHistory(CreatedEmployeePositionHistoryDTO dto) {
        return employeePositionHistoryMapper.toDto(
                employeePositionHistoryRepository.save(
                        EmployeePositionHistory.builder()
                                .employee(employeeRepository.findById(dto.getEmployee().getId())
                                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found.")))
                                .position(positionRepository.findById(dto.getPosition().getId())
                                        .orElseThrow(() -> new ResourceNotFoundException("Position not found.")))
                                .unit(unitRepository.findById(dto.getPosition().getId())
                                        .orElseThrow(() -> new ResourceNotFoundException("Unit not found.")))
                                .startDate(dto.getStartDate())
                                .endDate(dto.getEndDate())
                                .build()
                )
        );
    }

    @Override
    public EmployeePositionHistoryDTO updateEmployeePositionHistory(UpdatedEmployeePositionHistoryDTO dto, Long id) {
        EmployeePositionHistory employeePositionHistory = employeePositionHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee position history not found."));
        employeePositionHistory.setEmployee(employeeRepository.findById(dto.getEmployee().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found.")));
        employeePositionHistory.setPosition(positionRepository.findById(dto.getPosition().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Position not found.")));
        employeePositionHistory.setUnit(unitRepository.findById(dto.getPosition().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found.")));
        employeePositionHistory.setStartDate(dto.getStartDate());
        employeePositionHistory.setEndDate(dto.getEndDate());
        return employeePositionHistoryMapper.toDto(employeePositionHistoryRepository.save(employeePositionHistory));
    }

    @Override
    public EmployeePositionHistoryDTO deleteEmployeePositionHistory(Long id) {
        EmployeePositionHistory employeePositionHistory = employeePositionHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee position history not found."));
        employeePositionHistoryRepository.delete(employeePositionHistory);
        return employeePositionHistoryMapper.toDto(employeePositionHistory);
    }
}
