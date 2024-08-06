package com.jpa.project.service;

import com.jpa.project.model.DTO.UserDTO;
import com.jpa.project.model.entities.Department;
import com.jpa.project.model.entities.User;
import com.jpa.project.repository.DepartmentRepository;
import com.jpa.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        if (userDTO.getDepartmentId() != null) {
            Optional<Department> existingDepartment = departmentRepository.findById(userDTO.getDepartmentId());
            if (existingDepartment.isPresent()) {
                user.setDepartment(existingDepartment.get());
            } else {
                throw new RuntimeException("Department not found with id " + userDTO.getDepartmentId());
            }
        }

        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userDTO.getName());
                    user.setEmail(userDTO.getEmail());

                    // Optionally, update the department as well
                    if (userDTO.getDepartmentId() != null) {
                        Optional<Department> existingDepartment = departmentRepository.findById(userDTO.getDepartmentId());
                        existingDepartment.ifPresent(user::setDepartment);
                    }

                    User updatedUser = userRepository.save(user);
                    return convertToDTO(updatedUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        if (user.getDepartment() != null) {
            userDTO.setDepartmentId(user.getDepartment().getId());
        }
        return userDTO;
    }
}

