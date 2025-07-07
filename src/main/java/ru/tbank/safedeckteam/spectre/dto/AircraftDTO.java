package ru.tbank.safedeckteam.spectre.dto;

import lombok.Data;

@Data
public class AircraftDTO {

    private Long id;

    private String modelName;

    private String description;

    private String manufacturer;

    private AircraftTypeDTO aircraftType;
}
