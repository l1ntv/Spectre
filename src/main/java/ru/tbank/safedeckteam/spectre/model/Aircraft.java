package ru.tbank.safedeckteam.spectre.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "aircraft")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelName;

    @Column
    private String description;

    @Column
    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AircraftType type;

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Test> tests;
}
