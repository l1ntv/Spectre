package ru.tbank.safedeckteam.spectre.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "aircraft")
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    private AircraftType type;

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Test> tests;
}
