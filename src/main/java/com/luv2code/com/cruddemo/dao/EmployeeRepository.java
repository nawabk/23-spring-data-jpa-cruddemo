package com.luv2code.com.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.com.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//that's it....no need to write any other code
}
