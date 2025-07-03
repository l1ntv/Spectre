package ru.tbank.safedeckteam.spectre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tbank.safedeckteam.spectre.model.EmployeeTestParticipation;

@Repository
public interface EmployeeTestParticipationRepository extends JpaRepository<EmployeeTestParticipation, Long> {

}
