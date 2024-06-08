package com.emirhanarici.springbootgraphql.controller;

import com.emirhanarici.springbootgraphql.model.Address;
import com.emirhanarici.springbootgraphql.model.Contact;
import com.emirhanarici.springbootgraphql.model.Employee;
import com.emirhanarici.springbootgraphql.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @MutationMapping
    public Employee createEmployee(@Argument("employee") Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @QueryMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @QueryMapping
    public Employee getEmployeeById(@Argument("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @SchemaMapping
    public List<Contact> contacts(Employee employee) {
        return employee.getContacts();
    }

    @SchemaMapping
    public Address address(Employee employee) {
        return employee.getAddress();
    }


}
