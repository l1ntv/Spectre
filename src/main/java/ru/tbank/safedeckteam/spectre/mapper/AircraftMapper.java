package ru.tbank.safedeckteam.spectre.mapper;

import org.mapstruct.Mapper;
import ru.tbank.safedeckteam.spectre.dto.AircraftDTO;
import ru.tbank.safedeckteam.spectre.model.Aircraft;

@Mapper(componentModel = "spring")
public interface AircraftMapper extends Mappable<Aircraft, AircraftDTO> {
}
