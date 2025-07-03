package ru.tbank.safedeckteam.spectre.service;

import ru.tbank.safedeckteam.spectre.dto.*;

import java.util.List;

public interface UnitService {

    List<UnitDTO> findAllUnits();

    UnitDTO findUnitById(Long id);

    UnitDTO createUnit(CreatedUnitDTO dto);

    UnitDTO updateUnit(UpdatedUnitDTO dto, Long id);

    UnitDTO deleteUnit(Long id);
}
