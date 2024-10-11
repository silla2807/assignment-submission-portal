package com.growthx.assignmentportal.serviceImpl;

import com.growthx.assignmentportal.dto.LoginDto;
import com.growthx.assignmentportal.model.Assignment;
import com.growthx.assignmentportal.model.User;
import com.growthx.assignmentportal.repository.AssignmentRespository;
import com.growthx.assignmentportal.repository.UserRepository;
import com.growthx.assignmentportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssignmentRespository assignmentRespository;

    @Autowired
    private com.growthx.assignmentportal.Utils.utilities utilities;

    @Override
    public ResponseEntity<String> userRegister(User user) {
        if (userRepository.existsByUserId(user.getUserId())) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(utilities.USER_EXISTS);
        }

        if (!user.getPassword().matches(utilities.PASSWORD_PATTERN)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(utilities.PASSWORD_INVALID);
        }

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registration successful");
    }

    @Override
    public ResponseEntity<String> login(LoginDto loginDto) {
        Optional<User> currentUser = userRepository.findByUserId(loginDto.getUserId());

        if (currentUser.isEmpty() || !loginDto.getPassword().matches(currentUser.get().getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        return ResponseEntity.ok("Login Successful");
    }

    @Override
    public ResponseEntity<?> getAllAdmins() {
        List<User> response = userRepository.findByRole("ADMIN");
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No admins found");
        }
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> uploadAssignment(Assignment assignment) {
        // check if the same userId and task is existing in db
        if(!assignmentRespository.findByUserId(assignment.getUserId()).isEmpty() && !assignmentRespository.findByTask(assignment.getTask()).isEmpty()){
            return ResponseEntity.ok("Assignment exists");
        }
        assignment.setStatus("PENDING");
        assignment.setSubmittedAt(LocalDateTime.now());
        assignmentRespository.save(assignment);
        return ResponseEntity.ok("Assignment uploaded successfully!");
    }
}
