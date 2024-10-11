package com.growthx.assignmentportal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "assignments")
public class Assignment {
    @Id
    private String id;
    private String userId;
    private String task;
    private String admin;
    private LocalDateTime submittedAt;
    private String status;


    public Assignment() {
        this.submittedAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", task='" + task + '\'' +
                ", admin='" + admin + '\'' +
                ", submittedAt=" + submittedAt +
                ", status='" + status + '\'' +
                '}';
    }
}
