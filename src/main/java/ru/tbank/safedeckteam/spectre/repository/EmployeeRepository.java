package ru.tbank.safedeckteam.spectre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tbank.safedeckteam.spectre.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
