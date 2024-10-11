package com.growthx.assignmentportal.service;

import com.growthx.assignmentportal.model.Assignment;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<?> viewAssignments(String admin);

    Assignment acceptAssignment(String id);

    Assignment rejectAssignment(String id);
}
