package com.bridgelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabs.model.EmployeePayrollData;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeePayrollData	, Integer>{

}
