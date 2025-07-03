package ru.tbank.safedeckteam.spectre.service;

import ru.tbank.safedeckteam.spectre.dto.*;

import java.util.List;

public interface AircraftTypeService {

    List<AircraftTypeDTO> findAllAircraftTypes();

    AircraftTypeDTO findAircraftTypeById(Long id);

    AircraftTypeDTO createAircraftType(CreatedAircraftTypeDTO dto);

    AircraftTypeDTO renameAircraftType(RenamedAircraftTypeDTO dto, Long id);

    AircraftTypeDTO deleteAircraftType(Long id);
}
