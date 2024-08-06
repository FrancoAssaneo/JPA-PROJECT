package com.jpa.project.model.DTO;

import java.util.List;

public class BuildingDTO {

    private Long id;
    private String name;
    private String address;
    private List<Long> departmentIds;

    public BuildingDTO() {
    }

    public BuildingDTO(Long id, String name, String address, List<Long> departmentIds) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.departmentIds = departmentIds;
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

    public List<Long> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<Long> departmentIds) {
        this.departmentIds = departmentIds;
    }

    @Override
    public String toString() {
        return "BuildingDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", departmentIds=" + departmentIds +
                '}';
    }
}
