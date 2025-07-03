package ru.tbank.safedeckteam.spectre.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tbank.safedeckteam.spectre.dto.AircraftTypeDTO;
import ru.tbank.safedeckteam.spectre.dto.CreatedAircraftTypeDTO;
import ru.tbank.safedeckteam.spectre.dto.RenamedAircraftTypeDTO;
import ru.tbank.safedeckteam.spectre.exception.ResourceNotFoundException;
import ru.tbank.safedeckteam.spectre.mapper.AircraftTypeMapper;
import ru.tbank.safedeckteam.spectre.model.AircraftType;
import ru.tbank.safedeckteam.spectre.repository.AircraftTypeRepository;
import ru.tbank.safedeckteam.spectre.service.AircraftTypeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftTypeServiceImpl implements AircraftTypeService {

    private final AircraftTypeRepository aircraftTypeRepository;

    private final AircraftTypeMapper aircraftTypeMapper;

    @Override
    public List<AircraftTypeDTO> findAllAircraftTypes() {
        return aircraftTypeMapper.toDtoList(aircraftTypeRepository.findAll());
    }

    @Override
    public AircraftTypeDTO findAircraftTypeById(Long id) {
        return aircraftTypeMapper.toDto(aircraftTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft type not found.")));
    }

    @Override
    public AircraftTypeDTO createAircraftType(CreatedAircraftTypeDTO dto) {
        return aircraftTypeMapper.toDto(aircraftTypeRepository.save(AircraftType.builder()
                .name(dto.getName())
                .build()));
    }

    @Override
    public AircraftTypeDTO renameAircraftType(RenamedAircraftTypeDTO dto, Long id) {
        AircraftType aircraftType = aircraftTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft type not found."));
        aircraftType.setName(dto.getNewName());
        return aircraftTypeMapper.toDto(aircraftTypeRepository.save(aircraftType));
    }

    @Override
    public AircraftTypeDTO deleteAircraftType(Long id) {
        AircraftType aircraftType = aircraftTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft type not found."));
        aircraftTypeRepository.delete(aircraftType);
        return aircraftTypeMapper.toDto(aircraftType);
    }
}
