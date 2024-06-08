package com.emirhanarici.springbootgraphql.service;

import com.emirhanarici.springbootgraphql.exception.EmployeeNotFoundException;
import com.emirhanarici.springbootgraphql.model.Employee;
import com.emirhanarici.springbootgraphql.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public Employee createEmployee(Employee employee) {
        log.info("Employee created: {}", employee.getName());
        return employeeRepository.save(employee);

    }

    public List<Employee> getEmployees() {
        log.info("All employees listed");
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        log.info("Employee listed by id: {}", id);
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found by id: " + id));
    }


}
