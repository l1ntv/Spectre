package ru.tbank.safedeckteam.spectre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.safedeckteam.spectre.model.Aircraft;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}
