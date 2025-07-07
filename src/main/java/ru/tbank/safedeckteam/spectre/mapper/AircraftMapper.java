package ru.tbank.safedeckteam.spectre.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.tbank.safedeckteam.spectre.dto.AircraftDTO;
import ru.tbank.safedeckteam.spectre.model.Aircraft;

@Mapper(componentModel = "spring")
public interface AircraftMapper extends Mappable<Aircraft, AircraftDTO> {

    @Mapping(source = "type", target = "aircraftType")
    AircraftDTO toDto(Aircraft aircraft);

    @Mapping(source = "aircraftType", target = "type")
    Aircraft toEntity(AircraftDTO dto);
}
