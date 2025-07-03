package ru.tbank.safedeckteam.spectre.mapper;

import org.mapstruct.Mapper;
import ru.tbank.safedeckteam.spectre.dto.AircraftTypeDTO;
import ru.tbank.safedeckteam.spectre.model.AircraftType;

@Mapper(componentModel = "spring")
public interface AircraftTypeMapper extends Mappable<AircraftType, AircraftTypeDTO> {

}
