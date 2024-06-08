package com.emirhanarici.springbootgraphql.repository;

import com.emirhanarici.springbootgraphql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
