package com.ednach.postgres.springbootpostgresdocker;

import com.ednach.postgres.springbootpostgresdocker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
