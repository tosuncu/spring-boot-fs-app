package com.tosuncu.springemployeefullstack.service;

import com.tosuncu.springemployeefullstack.entity.Employee;
import com.tosuncu.springemployeefullstack.exception.UserNotFoundException;
import com.tosuncu.springemployeefullstack.repo.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeService.class);


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        LOGGER.info("itdsfsdfsdfsd");
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeByid(id);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id).orElseThrow(()->
                new UserNotFoundException("User by id "+ id +"not found!" ));
    }
}
