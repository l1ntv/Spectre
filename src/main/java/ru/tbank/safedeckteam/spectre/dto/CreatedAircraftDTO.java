package ru.tbank.safedeckteam.spectre.dto;

import lombok.Data;

@Data
public class CreatedAircraftDTO {

    private String modelName;

    private String description;

    private String manufacturer;

    private AircraftTypeDTO aircraftType;
}
