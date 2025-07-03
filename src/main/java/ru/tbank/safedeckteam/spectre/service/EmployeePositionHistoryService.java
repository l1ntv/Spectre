package ru.tbank.safedeckteam.spectre.service;

import ru.tbank.safedeckteam.spectre.dto.*;

import java.util.List;

public interface EmployeePositionHistoryService {

    List<EmployeePositionHistoryDTO> findAllEmployeesPositionsHistories();

    EmployeePositionHistoryDTO findEmployeePositionHistory(Long id);

    EmployeePositionHistoryDTO createEmployeePositionHistory(CreatedEmployeePositionHistoryDTO dto);

    EmployeePositionHistoryDTO updateEmployeePositionHistory(UpdatedEmployeePositionHistoryDTO dto, Long id);

    EmployeePositionHistoryDTO deleteEmployeePositionHistory(Long id);
}
