package com.emirhanarici.springbootgraphql.service;

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
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }


}
