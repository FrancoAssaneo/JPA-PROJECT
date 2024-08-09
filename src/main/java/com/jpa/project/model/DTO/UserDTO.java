package com.jpa.project.model.DTO;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String departmentNumber;

    public UserDTO() {}

    public UserDTO(Long id, String name, String email, String departmentNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentNumber = departmentNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", departmentNumber=" + departmentNumber +
                '}';
    }
}
