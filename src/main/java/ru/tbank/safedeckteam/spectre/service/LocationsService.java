package ru.tbank.safedeckteam.spectre.service;

import ru.tbank.safedeckteam.spectre.dto.CreatedLocationDTO;
import ru.tbank.safedeckteam.spectre.dto.LocationDTO;
import ru.tbank.safedeckteam.spectre.dto.UpdatedLocationDTO;

import java.util.List;

public interface LocationsService {

    List<LocationDTO> findAllLocations();

    LocationDTO findLocationById(Long id);

    LocationDTO createLocation(CreatedLocationDTO dto);

    LocationDTO updateLocation(UpdatedLocationDTO dto, Long id);

    LocationDTO deleteLocation(Long id);
}
