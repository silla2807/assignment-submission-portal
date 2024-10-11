package com.growthx.assignmentportal.serviceImpl;

import com.growthx.assignmentportal.model.Assignment;
import com.growthx.assignmentportal.repository.AssignmentRespository;
import com.growthx.assignmentportal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AssignmentRespository assignmentRespository;

    @Override
    public ResponseEntity<?> viewAssignments(String admin) {
        List<Assignment> assignments = assignmentRespository.findByAdmin(admin);//find assignments tagged to any admin
        if(assignments.isEmpty()){
            return ResponseEntity.ok(" No Assignments found");
        }
        return ResponseEntity.ok(assignments);
    }

    @Override
    public Assignment acceptAssignment(String id) {
        return updateAssignmentStatus(id,"ACCEPTED");
    }

    @Override
    public Assignment rejectAssignment(String id) {
        return updateAssignmentStatus(id,"REJECTED");
    }
    // common method to update status
    private Assignment updateAssignmentStatus(String id, String status){
        Optional<Assignment> assignments = assignmentRespository.findById(id);
        if (assignments.isPresent()) {
            Assignment assignment = assignments.get();
            assignment.setStatus(status);
            return assignmentRespository.save(assignment);
        }
        return null;
    }
}
