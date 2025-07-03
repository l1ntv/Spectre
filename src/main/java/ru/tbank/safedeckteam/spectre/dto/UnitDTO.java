package ru.tbank.safedeckteam.spectre.dto;

import lombok.Data;

@Data
public class UnitDTO {

    private Long id;

    private OrganizationDTO organization;

    private UnitDTO parent;

    private String name;
}
