package ru.tbank.safedeckteam.spectre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tbank.safedeckteam.spectre.model.AircraftType;

import java.util.Optional;

@Repository
public interface AircraftTypeRepository extends JpaRepository<AircraftType, Long> {
}
