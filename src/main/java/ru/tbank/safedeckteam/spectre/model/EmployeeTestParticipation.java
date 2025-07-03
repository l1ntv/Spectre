package ru.tbank.safedeckteam.spectre.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_test_participation")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeTestParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private String notes;
}
