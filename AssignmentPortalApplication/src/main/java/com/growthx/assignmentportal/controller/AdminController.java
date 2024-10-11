package com.growthx.assignmentportal.controller;

import com.growthx.assignmentportal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/assignments/{admin}")
    public ResponseEntity<?> viewAssignments(@PathVariable String admin) {
        try {
            return ResponseEntity.ok(adminService.viewAssignments(admin).getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/assignments/{id}/accept")
    public ResponseEntity<?> acceptAssignment(@PathVariable String id) {
        return ResponseEntity.ok(adminService.acceptAssignment(id));
        }

    @PostMapping("/assignments/{id}/reject")
    public ResponseEntity<?> rejectAssignment(@PathVariable String id) {
        return ResponseEntity.ok(adminService.rejectAssignment(id));
    }

}
