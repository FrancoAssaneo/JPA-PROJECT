package com.jpa.project.model.DTO;

import java.util.List;

public class BuildingDTO {

    private Long id;
    private String name;
    private String address;
    private List<DepartmentDTO> departmentList;

    public BuildingDTO() {
    }

    public BuildingDTO(Long id, String name, String address, List<DepartmentDTO> departmentList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.departmentList = departmentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<DepartmentDTO> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<DepartmentDTO> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public String toString() {
        return "BuildingDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", departmentIds=" + departmentList +
                '}';
    }
}
