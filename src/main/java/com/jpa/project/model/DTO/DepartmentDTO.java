package com.jpa.project.model.DTO;

import java.util.List;

public class DepartmentDTO {

    private Long id;
    private String doorNumber;
    private String floor;
    private List<UserDTO> users;
    private Long buildingId;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long id, String doorNumber, String floor, List<UserDTO> users, Long buildingId) {
        this.id = id;
        this.doorNumber = doorNumber;
        this.floor = floor;
        this.users = users;
        this.buildingId = buildingId;
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

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", doorNumber='" + doorNumber + '\'' +
                ", floor='" + floor + '\'' +
                ", users=" + users +
                ", buildingId=" + buildingId +
                '}';
    }
}
