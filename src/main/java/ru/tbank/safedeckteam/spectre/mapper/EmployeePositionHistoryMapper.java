package ru.tbank.safedeckteam.spectre.mapper;

import org.mapstruct.Mapper;
import ru.tbank.safedeckteam.spectre.dto.EmployeePositionHistoryDTO;
import ru.tbank.safedeckteam.spectre.model.EmployeePositionHistory;

@Mapper(componentModel = "spring")
public interface EmployeePositionHistoryMapper extends Mappable<EmployeePositionHistory, EmployeePositionHistoryDTO> {

}
