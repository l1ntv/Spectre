package ru.tbank.safedeckteam.spectre.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatedEmployeeDTO {

    private String email;

    private LocalDate birthDate;

    private String fullName;
}
