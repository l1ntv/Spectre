package ru.tbank.safedeckteam.spectre.mapper;

import org.mapstruct.Mapper;
import ru.tbank.safedeckteam.spectre.dto.PositionDTO;
import ru.tbank.safedeckteam.spectre.model.Position;

@Mapper(componentModel = "spring")
public interface PositionMapper extends Mappable<Position, PositionDTO> {

}
