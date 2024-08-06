package com.jpa.project.controller;

import com.jpa.project.model.DTO.DepartmentDTO;
import com.jpa.project.repository.projections.DepartmentProjection;
import com.jpa.project.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.ok(createdDepartment);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/floor/{floorNumber}")
    public ResponseEntity<List<DepartmentDTO>> getDepartmentsByFloor(@PathVariable String floorNumber) {
        List<DepartmentDTO> departmentsByFloor = departmentService.getDepartmentsByFloor(floorNumber);
        return ResponseEntity.ok(departmentsByFloor);
    }

    @GetMapping("/ids-and-doors")
    public List<DepartmentProjection> getAllDepartmentIdsAndDoorNumbers() {
        return departmentService.getAllDepartmentIdsAndDoorNumbers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO updatedDepartment = departmentService.updateDepartment(id, departmentDTO);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
