package ru.tbank.safedeckteam.spectre.mapper;

import org.mapstruct.Mapper;
import ru.tbank.safedeckteam.spectre.dto.OrganizationDTO;
import ru.tbank.safedeckteam.spectre.model.Organization;

@Mapper(componentModel = "spring")
public interface OrganizationMapper extends Mappable<Organization, OrganizationDTO> {

}
