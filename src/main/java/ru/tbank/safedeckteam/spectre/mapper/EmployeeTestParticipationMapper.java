package ru.tbank.safedeckteam.spectre.mapper;

import org.mapstruct.Mapper;
import ru.tbank.safedeckteam.spectre.dto.EmployeeTestParticipationDTO;
import ru.tbank.safedeckteam.spectre.model.EmployeeTestParticipation;

@Mapper(componentModel = "spring")
public interface EmployeeTestParticipationMapper extends Mappable<EmployeeTestParticipation, EmployeeTestParticipationDTO> {

}
