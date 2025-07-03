package ru.tbank.safedeckteam.spectre.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tbank.safedeckteam.spectre.dto.CreatedOrganizationDTO;
import ru.tbank.safedeckteam.spectre.dto.OrganizationDTO;
import ru.tbank.safedeckteam.spectre.dto.RenamedOrganizationDTO;
import ru.tbank.safedeckteam.spectre.mapper.OrganizationMapper;
import ru.tbank.safedeckteam.spectre.model.Organization;
import ru.tbank.safedeckteam.spectre.repository.OrganizationRepository;
import ru.tbank.safedeckteam.spectre.service.OrganizationsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationsService {

    private final OrganizationRepository organizationRepository;

    private final OrganizationMapper organizationMapper;

    @Override
    public List<OrganizationDTO> findAllOrganizations() {
        return organizationMapper.toDtoList(organizationRepository.findAll());
    }

    @Override
    public OrganizationDTO findOrganizationById(Long id) {
        return organizationMapper.toDto(organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found")));
    }

    @Override
    public OrganizationDTO createOrganization(CreatedOrganizationDTO organization) {
        return organizationMapper.toDto(organizationRepository.save(Organization.builder()
                .name(organization.getName())
                .build()));
    }

    @Override
    public OrganizationDTO renameOrganization(RenamedOrganizationDTO organization, Long organizationId) {
        Organization organizationEntity = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException("Organization not found."));
        organizationEntity.setName(organization.getNewName());
        return organizationMapper.toDto(organizationRepository.save(organizationEntity));
    }

    @Override
    public OrganizationDTO deleteOrganization(Long organizationId) {
        Organization organizationEntity = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException("Organization not found."));
        organizationRepository.delete(organizationEntity);
        return organizationMapper.toDto(organizationEntity);
    }
}
