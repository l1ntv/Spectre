package ru.tbank.safedeckteam.spectre.dto;

import lombok.Data;

@Data
public class CreatedUnitDTO {

    private OrganizationDTO organization;

    private UnitDTO parent;

    private String name;
}
