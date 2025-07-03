package ru.tbank.safedeckteam.spectre.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tbank.safedeckteam.spectre.dto.CreatedLocationDTO;
import ru.tbank.safedeckteam.spectre.dto.LocationDTO;
import ru.tbank.safedeckteam.spectre.dto.UpdatedLocationDTO;
import ru.tbank.safedeckteam.spectre.exception.ResourceNotFoundException;
import ru.tbank.safedeckteam.spectre.mapper.LocationMapper;
import ru.tbank.safedeckteam.spectre.model.Location;
import ru.tbank.safedeckteam.spectre.repository.LocationRepository;
import ru.tbank.safedeckteam.spectre.service.LocationsService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LocationServiceImpl implements LocationsService {

    private final LocationRepository locationRepository;

    private final LocationMapper locationMapper;

    @Override
    public List<LocationDTO> findAllLocations() {
        return locationMapper.toDtoList(locationRepository.findAll());
    }

    @Override
    public LocationDTO findLocationById(Long id) {
        return locationMapper.toDto(locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found.")));
    }

    @Override
    public LocationDTO createLocation(CreatedLocationDTO dto) {
        return locationMapper.toDto(locationRepository.save(Location.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .build()));
    }

    @Override
    public LocationDTO updateLocation(UpdatedLocationDTO dto, Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found."));
        location.setName(dto.getName());
        location.setAddress(dto.getAddress());
        return locationMapper.toDto(locationRepository.save(location));
    }

    @Override
    public LocationDTO deleteLocation(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found"));
        locationRepository.delete(location);
        return locationMapper.toDto(location);
    }
}
