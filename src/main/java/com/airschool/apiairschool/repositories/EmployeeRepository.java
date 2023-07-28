package com.airschool.apiairschool.repositories;

import com.airschool.apiairschool.model.Address;
import com.airschool.apiairschool.model.Employee;
import com.airschool.apiairschool.model.enums.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findEmployeeByPerfis (int perfilId);
    Optional<Employee> findByFunctionalNumber(Long functionalNumber);
}