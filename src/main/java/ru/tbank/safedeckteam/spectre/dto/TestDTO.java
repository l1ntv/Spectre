package ru.tbank.safedeckteam.spectre.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TestDTO {

    private Long id;

    private OrganizationDTO organization;

    private AircraftDTO aircraft;

    private LocationDTO location;

    private LocalDate date;

    private String description;
}
