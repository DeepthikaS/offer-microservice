package com.spring.mfpe.offer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.mfpe.offer.entities.Employee;

//to access employee database
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
