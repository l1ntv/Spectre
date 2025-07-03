package ru.tbank.safedeckteam.spectre.mapper;

import org.mapstruct.Mapper;
import ru.tbank.safedeckteam.spectre.dto.TestDTO;
import ru.tbank.safedeckteam.spectre.model.Test;

@Mapper(componentModel = "spring")
public interface TestMapper extends Mappable<Test, TestDTO> {

}
