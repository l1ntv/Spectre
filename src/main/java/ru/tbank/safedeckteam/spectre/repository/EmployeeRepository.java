package ru.tbank.safedeckteam.spectre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.safedeckteam.spectre.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
