package ru.tbank.safedeckteam.spectre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tbank.safedeckteam.spectre.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

}
