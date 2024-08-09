package com.jpa.project.service;

import com.jpa.project.model.DTO.BuildingDTO;
import com.jpa.project.model.DTO.DepartmentDTO;
import com.jpa.project.model.entities.Building;
import com.jpa.project.repository.BuildingRepository;
import com.jpa.project.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentService departmentService;

    public List<BuildingDTO> getAllBuildings() {
        return buildingRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BuildingDTO getBuildingById(Long id) {
        return buildingRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Building not found with id " + id));
    }

    public BuildingDTO createBuilding(BuildingDTO buildingDTO) {
        Building building = convertToEntity(buildingDTO);
        building.setDepartments(departmentRepository.findAllById(getDepartmentIds(buildingDTO.getDepartmentList())));
        Building savedBuilding = buildingRepository.save(building);
        return convertToDTO(savedBuilding);
    }

    public BuildingDTO updateBuilding(Long id, BuildingDTO buildingDTO) {
        return buildingRepository.findById(id)
                .map(building -> {
                    building.setName(buildingDTO.getName());
                    building.setAddress(buildingDTO.getAddress());
                    building.setDepartments(departmentRepository.findAllById(getDepartmentIds(buildingDTO.getDepartmentList())));
                    Building updatedBuilding = buildingRepository.save(building);
                    return convertToDTO(updatedBuilding);
                })
                .orElseThrow(() -> new RuntimeException("Building not found with id " + id));
    }

    public void deleteBuilding(Long id) {
        buildingRepository.deleteById(id);
    }

    private BuildingDTO convertToDTO(Building building) {
        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setId(building.getId());
        buildingDTO.setName(building.getName());
        buildingDTO.setAddress(building.getAddress());
        buildingDTO.setDepartmentList(departmentService.convertToDTOList(building.getDepartments()));
        return buildingDTO;
    }

    private Building convertToEntity(BuildingDTO buildingDTO) {
        Building building = new Building();
        building.setName(buildingDTO.getName());
        building.setAddress(buildingDTO.getAddress());
        if (buildingDTO.getDepartmentList() != null) {
            building.setDepartments(departmentRepository.findAllById(getDepartmentIds(buildingDTO.getDepartmentList())));
        }
        return building;
    }

    private List<Long> getDepartmentIds(List<DepartmentDTO> departments) {
        return departments.stream().map(DepartmentDTO::getId).collect(Collectors.toList());
    }
}
