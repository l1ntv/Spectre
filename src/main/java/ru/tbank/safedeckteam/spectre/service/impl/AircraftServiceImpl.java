package ru.tbank.safedeckteam.spectre.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tbank.safedeckteam.spectre.dto.AircraftDTO;
import ru.tbank.safedeckteam.spectre.dto.CreatedAircraftDTO;
import ru.tbank.safedeckteam.spectre.dto.UpdatedAircraftDTO;
import ru.tbank.safedeckteam.spectre.exception.ResourceNotFoundException;
import ru.tbank.safedeckteam.spectre.mapper.AircraftMapper;
import ru.tbank.safedeckteam.spectre.model.Aircraft;
import ru.tbank.safedeckteam.spectre.model.AircraftType;
import ru.tbank.safedeckteam.spectre.repository.AircraftRepository;
import ru.tbank.safedeckteam.spectre.repository.AircraftTypeRepository;
import ru.tbank.safedeckteam.spectre.service.AircraftService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository aircraftRepository;

    private final AircraftTypeRepository aircraftTypeRepository;

    private final AircraftMapper aircraftMapper;

    @Override
    public List<AircraftDTO> findAllAircrafts() {
        return aircraftMapper.toDtoList(aircraftRepository.findAll());
    }

    @Override
    public AircraftDTO findAircraftById(Long id) {
        return aircraftMapper.toDto(aircraftRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found.")));
    }

    @Override
    public AircraftDTO createAircraft(CreatedAircraftDTO dto) {
        AircraftType aircraftType = aircraftTypeRepository.findById(dto.getAircraftType().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft type not found."));

        return aircraftMapper.toDto(aircraftRepository.save(Aircraft.builder()
                .modelName(dto.getModelName())
                .description(dto.getDescription())
                .manufacturer(dto.getManufacturer())
                .type(aircraftType)
                .build()));
    }

    @Override
    public AircraftDTO updateAircraft(UpdatedAircraftDTO dto, Long id) {
        Aircraft aircraft = aircraftRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found."));
        aircraft.setModelName(dto.getModelName());
        aircraft.setDescription(dto.getDescription());
        aircraft.setManufacturer(dto.getManufacturer());
        aircraft.setType(aircraftTypeRepository.findById(dto.getAircraftType().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft type not found.")));
        return aircraftMapper.toDto(aircraftRepository.save(aircraft));
    }

    @Override
    public AircraftDTO deleteAircraft(Long id) {
        Aircraft aircraft = aircraftRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found."));
        aircraftRepository.delete(aircraft);
        return aircraftMapper.toDto(aircraft);
    }
}
