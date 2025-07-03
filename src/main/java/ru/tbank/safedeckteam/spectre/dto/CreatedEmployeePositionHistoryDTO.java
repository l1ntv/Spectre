package ru.tbank.safedeckteam.spectre.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatedEmployeePositionHistoryDTO {

    private EmployeeDTO employee;

    private PositionDTO position;

    private UnitDTO unit;

    private LocalDate startDate;

    private LocalDate endDate;
}
