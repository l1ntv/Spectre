package ru.tbank.safedeckteam.spectre.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tbank.safedeckteam.spectre.dto.CreatedEmployeeDTO;
import ru.tbank.safedeckteam.spectre.dto.EmployeeDTO;
import ru.tbank.safedeckteam.spectre.dto.UpdatedEmployeeDTO;
import ru.tbank.safedeckteam.spectre.mapper.EmployeeMapper;
import ru.tbank.safedeckteam.spectre.model.Employee;
import ru.tbank.safedeckteam.spectre.repository.EmployeeRepository;
import ru.tbank.safedeckteam.spectre.service.EmployeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO findEmployeeById(Long id) {
        return employeeMapper.toDto(employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found.")));
    }

    @Override
    public EmployeeDTO createEmployee(CreatedEmployeeDTO dto) {
        return employeeMapper.toDto(employeeRepository.save(Employee.builder()
                .email(dto.getEmail())
                .birthDate(dto.getBirthDate())
                .fullName(dto.getFullName())
                .build()));
    }

    @Override
    public EmployeeDTO updateEmployee(UpdatedEmployeeDTO dto, Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found."));
        employee.setEmail(dto.getEmail());
        employee.setBirthDate(dto.getBirthDate());
        employee.setFullName(dto.getFullName());
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found."));
        employeeRepository.delete(employee);
        return employeeMapper.toDto(employee);
    }
}
