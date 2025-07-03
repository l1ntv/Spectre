package ru.tbank.safedeckteam.spectre.service;

import ru.tbank.safedeckteam.spectre.dto.*;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAllEmployees();

    EmployeeDTO findEmployeeById(Long id);

    EmployeeDTO createEmployee(CreatedEmployeeDTO dto);

    EmployeeDTO updateEmployee(UpdatedEmployeeDTO dto, Long id);

    EmployeeDTO deleteEmployee(Long id);
}
