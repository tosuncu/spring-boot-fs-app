package com.tosuncu.springemployeefullstack.repo;

import com.tosuncu.springemployeefullstack.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    void deleteEmployeeByid(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
