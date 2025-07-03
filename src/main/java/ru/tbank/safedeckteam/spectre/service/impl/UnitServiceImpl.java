package ru.tbank.safedeckteam.spectre.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tbank.safedeckteam.spectre.dto.CreatedUnitDTO;
import ru.tbank.safedeckteam.spectre.dto.UnitDTO;
import ru.tbank.safedeckteam.spectre.dto.UpdatedUnitDTO;
import ru.tbank.safedeckteam.spectre.exception.ResourceNotFoundException;
import ru.tbank.safedeckteam.spectre.mapper.UnitMapper;
import ru.tbank.safedeckteam.spectre.model.Unit;
import ru.tbank.safedeckteam.spectre.repository.OrganizationRepository;
import ru.tbank.safedeckteam.spectre.repository.UnitRepository;
import ru.tbank.safedeckteam.spectre.service.UnitService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;

    private final UnitMapper unitMapper;

    private final OrganizationRepository organizationRepository;

    @Override
    public List<UnitDTO> findAllUnits() {
        return unitMapper.toDtoList(unitRepository.findAll());
    }

    @Override
    public UnitDTO findUnitById(Long id) {
        return unitMapper.toDto(unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found")));
    }

    @Override
    public UnitDTO createUnit(CreatedUnitDTO dto) {
        return unitMapper.toDto(unitRepository.save(Unit.builder()
                .name(dto.getName())
                .parentUnit(unitRepository.findById(dto.getParent().getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Parent unit not found.")))
                .organization(organizationRepository.findById(dto.getOrganization().getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Organization not found.")))
                .build()));
    }

    @Override
    public UnitDTO updateUnit(UpdatedUnitDTO dto, Long id) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found."));
        unit.setName(dto.getName());
        unit.setParentUnit(unitRepository.findById(dto.getParent().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Parent unit not found.")));
        unit.setOrganization(organizationRepository.findById(dto.getOrganization().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found.")));
        return unitMapper.toDto(unitRepository.save(unit));
    }

    @Override
    public UnitDTO deleteUnit(Long id) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found."));
        unitRepository.delete(unit);
        return unitMapper.toDto(unit);
    }
}
