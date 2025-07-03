package ru.tbank.safedeckteam.spectre.service;

import ru.tbank.safedeckteam.spectre.dto.*;

import java.util.List;

public interface AircraftService {

    List<AircraftDTO> findAllAircrafts();

    AircraftDTO findAircraftById(Long id);

    AircraftDTO createAircraft(CreatedAircraftDTO dto);

    AircraftDTO updateAircraft(UpdatedAircraftDTO dto, Long id);

    AircraftDTO deleteAircraft(Long id);
}
