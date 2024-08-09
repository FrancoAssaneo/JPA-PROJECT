package com.jpa.project.model.DTO;

import java.util.List;

public class DepartmentDTO {

    private Long id;
    private String doorNumber;
    private String floor;
    private List<UserDTO> users;
    private String buildingName;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String doorNumber, String floor, List<UserDTO> users, String buildingName) {
        this.id = id;
        this.doorNumber = doorNumber;
        this.floor = floor;
        this.users = users;
        this.buildingName = buildingName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", doorNumber='" + doorNumber + '\'' +
                ", floor='" + floor + '\'' +
                ", users=" + users +
                ", buildingName=" + buildingName +
                '}';
    }
}
