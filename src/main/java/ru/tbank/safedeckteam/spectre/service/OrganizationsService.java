package ru.tbank.safedeckteam.spectre.service;

import ru.tbank.safedeckteam.spectre.dto.CreatedOrganizationDTO;
import ru.tbank.safedeckteam.spectre.dto.OrganizationDTO;
import ru.tbank.safedeckteam.spectre.dto.RenamedOrganizationDTO;

import java.util.List;

public interface OrganizationsService {

    List<OrganizationDTO> findAllOrganizations();

    OrganizationDTO findOrganizationById(Long id);

    OrganizationDTO createOrganization(CreatedOrganizationDTO organization);

    OrganizationDTO renameOrganization(RenamedOrganizationDTO organization, Long organizationId);

    OrganizationDTO deleteOrganization(Long organizationId);
}
