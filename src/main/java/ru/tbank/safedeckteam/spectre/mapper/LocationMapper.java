package ru.tbank.safedeckteam.spectre.mapper;

import org.mapstruct.Mapper;
import ru.tbank.safedeckteam.spectre.dto.LocationDTO;
import ru.tbank.safedeckteam.spectre.model.Location;

@Mapper(componentModel = "spring")
public interface LocationMapper extends Mappable<Location, LocationDTO> {

}
