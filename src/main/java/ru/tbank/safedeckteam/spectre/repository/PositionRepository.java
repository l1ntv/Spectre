package ru.tbank.safedeckteam.spectre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.safedeckteam.spectre.model.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
