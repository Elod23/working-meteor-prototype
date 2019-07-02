package com.prototype.meteor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Employee;

@Repository
public interface EmployeeRepostiory  extends JpaRepository<Employee, Integer>{

}
