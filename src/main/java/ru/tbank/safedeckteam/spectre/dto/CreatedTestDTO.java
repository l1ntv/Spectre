package ru.tbank.safedeckteam.spectre.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatedTestDTO {

    private AircraftDTO aircraft;

    private OrganizationDTO organization;

    private LocationDTO location;

    private LocalDate date;

    private String description;
}
