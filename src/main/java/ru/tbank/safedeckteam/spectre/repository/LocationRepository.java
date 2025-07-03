package ru.tbank.safedeckteam.spectre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.safedeckteam.spectre.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
