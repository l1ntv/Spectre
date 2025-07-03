package ru.tbank.safedeckteam.spectre.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "aircraft_type")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AircraftType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aircraft> aircrafts;
}
