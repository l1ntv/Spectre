package ru.tbank.safedeckteam.spectre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReportOrganizationsByAircraftTestsDTO {

    private Long id;

    private String name;

    private LocalDate date;
}
