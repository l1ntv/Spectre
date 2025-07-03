package ru.tbank.safedeckteam.spectre.dto;

import lombok.Data;

@Data
public class UpdatedUnitDTO {

    private OrganizationDTO organization;

    private UnitDTO parent;

    private String name;
}
