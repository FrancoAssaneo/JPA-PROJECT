package com.jpa.project.repository;

import com.jpa.project.model.entities.Department;
import com.jpa.project.repository.projections.DepartmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM Department d WHERE d.floor = :floor")
    List<Department> findByFloor(@Param("floor") String floor);

    @Query("SELECT d.id as id, d.doorNumber as doorNumber FROM Department d")
    List<DepartmentProjection> findAllDepartmentIdsAndDoorNumbers();
}
