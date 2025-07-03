package ru.tbank.safedeckteam.spectre.mapper;

import org.mapstruct.Mapper;
import ru.tbank.safedeckteam.spectre.dto.EmployeeDTO;
import ru.tbank.safedeckteam.spectre.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends Mappable<Employee, EmployeeDTO> {

}
