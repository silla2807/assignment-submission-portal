package com.growthx.assignmentportal.repository;

import com.growthx.assignmentportal.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssignmentRespository extends MongoRepository<Assignment, String> {


    List<Assignment>  findByAdmin(String admin);

    List<Assignment> findByUserId(String userId);

    List<Assignment> findByTask(String task);
}
