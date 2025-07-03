package ru.tbank.safedeckteam.spectre.mapper;

import org.mapstruct.Mapper;
import ru.tbank.safedeckteam.spectre.dto.UnitDTO;
import ru.tbank.safedeckteam.spectre.model.Unit;

@Mapper(componentModel = "spring")
public interface UnitMapper extends Mappable<Unit, UnitDTO> {

}
