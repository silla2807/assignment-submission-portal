package com.growthx.assignmentportal.controller;

import com.growthx.assignmentportal.dto.LoginDto;
import com.growthx.assignmentportal.model.Assignment;
import com.growthx.assignmentportal.model.User;
import com.growthx.assignmentportal.repository.AssignmentRespository;
import com.growthx.assignmentportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AssignmentRespository assignmentRespository;

    @PostMapping("/register")
    public ResponseEntity<String> userRegister(@RequestBody User user) {
        try {
            user.setRole(user.getRole().toUpperCase());
            return userService.userRegister(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("User registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginDto loginDto) {
        try {
            return userService.login(loginDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("User login failed: " + e.getMessage());
        }
    }

    @GetMapping("/admins")
    public ResponseEntity<?> getAllAdmins() {
        return new ResponseEntity<>(userService.getAllAdmins().getBody(), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadAssignment(@RequestBody Assignment assignment) {
        try {
            ResponseEntity<?> response = userService.uploadAssignment(assignment);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Assignment upload failed: " + e.getMessage());
        }
    }
}
