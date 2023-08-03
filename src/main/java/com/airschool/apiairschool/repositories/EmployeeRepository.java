package com.airschool.apiairschool.repositories;

import com.airschool.apiairschool.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findEmployeeByPerfis (int perfilId);
    Optional<Employee> findByFunctionalNumber(Long functionalNumber);
    @Query("SELECT e.functionalNumber FROM Employee e WHERE e.id = (SELECT max(id) FROM Employee)")
    Long getLastFunctionalNumber();
}