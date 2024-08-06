package com.jpa.project.service;

import com.jpa.project.model.DTO.DepartmentDTO;
import com.jpa.project.model.DTO.UserDTO;
import com.jpa.project.model.entities.Building;
import com.jpa.project.model.entities.Department;
import com.jpa.project.model.entities.User;
import com.jpa.project.repository.BuildingRepository;
import com.jpa.project.repository.DepartmentRepository;
import com.jpa.project.repository.projections.DepartmentProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setDoorNumber(departmentDTO.getDoorNumber());
        department.setFloor(departmentDTO.getFloor());
        Building building = buildingRepository.findById(departmentDTO.getBuildingId())
                .orElseThrow(() -> new RuntimeException("Building not found with id " + departmentDTO.getBuildingId()));
        department.setBuilding(building);
        Department savedDepartment = departmentRepository.save(department);
        return convertToDTO(savedDepartment);
    }

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Department not found with id " + id));
    }

    public List<DepartmentDTO> getDepartmentsByFloor(String floor) {
        List<Department> departments = departmentRepository.findByFloor(floor);
        return departments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<DepartmentProjection> getAllDepartmentIdsAndDoorNumbers() {
        return departmentRepository.findAllDepartmentIdsAndDoorNumbers();
    }

    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        return departmentRepository.findById(id)
                .map(department -> {
                    department.setDoorNumber(departmentDTO.getDoorNumber());
                    department.setFloor(departmentDTO.getFloor());
                    Building building = buildingRepository.findById(departmentDTO.getBuildingId())
                            .orElseThrow(() -> new RuntimeException("Building not found with id " + departmentDTO.getBuildingId()));
                    department.setBuilding(building);
                    Department updatedDepartment = departmentRepository.save(department);
                    return convertToDTO(updatedDepartment);
                })
                .orElseThrow(() -> new RuntimeException("Department not found with id " + id));
    }

    public void deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Department not found with id " + id);
        }
    }

    private DepartmentDTO convertToDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setDoorNumber(department.getDoorNumber());
        departmentDTO.setFloor(department.getFloor());
        departmentDTO.setUsers(convertToUserDTOList(department.getUsers()));
        departmentDTO.setBuildingId(department.getBuilding().getId());
        return departmentDTO;
    }

    private List<UserDTO> convertToUserDTOList(List<User> users) {
        return users.stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(user.getId());
                    userDTO.setName(user.getName());
                    userDTO.setEmail(user.getEmail());
                    if (user.getDepartment() != null) {
                        userDTO.setDepartmentId(user.getDepartment().getId());
                    }
                    return userDTO;
                })
                .collect(Collectors.toList());
    }
}
