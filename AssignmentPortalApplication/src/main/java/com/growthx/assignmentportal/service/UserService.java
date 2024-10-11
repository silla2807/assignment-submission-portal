package com.growthx.assignmentportal.service;

import com.growthx.assignmentportal.dto.LoginDto;
import com.growthx.assignmentportal.model.Assignment;
import com.growthx.assignmentportal.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> userRegister(User user);
    ResponseEntity<String> login(LoginDto loginDto);
    ResponseEntity<?> getAllAdmins();
    ResponseEntity<?> uploadAssignment(Assignment assignment);
}
