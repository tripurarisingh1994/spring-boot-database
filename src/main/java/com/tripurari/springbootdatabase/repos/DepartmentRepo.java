package com.tripurari.springbootdatabase.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripurari.springbootdatabase.models.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
