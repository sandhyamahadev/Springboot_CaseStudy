package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CandidateAssessmentDTO;
import com.example.demo.entity.CandidateAssessment;
import com.example.demo.service.CandidateAssessmentService;

	@RestController
	@RequestMapping("/assignments")
	public class CandidateAssessmentController {

	    @Autowired
	    private CandidateAssessmentService candidateAssessmentService;

	    // Assign Assessment to Candidate
	    @PostMapping
	    public CandidateAssessment assignAssessment(@RequestBody CandidateAssessmentDTO dto) {
	        return candidateAssessmentService.assignAssessment(dto);
	    }

	    // Get All Assignments
	    @GetMapping
	    public List<CandidateAssessment> getAllAssignments() {
	        return candidateAssessmentService.getAllAssignments();
	    }

	    // Get Assignment By Id
	    @GetMapping("/{id}")
	    public CandidateAssessment getAssignmentById(@PathVariable Long id) {
	        return candidateAssessmentService.getAssignmentById(id);
	    }

	    // Update Status
	    @PutMapping("/status/{id}")
	    public CandidateAssessment updateStatus(@PathVariable Long id,
	                                            @RequestParam String status) {
	        return candidateAssessmentService.updateStatus(id, status);
	    }

	    // Update Score
	    @PutMapping("/score/{id}")
	    public CandidateAssessment updateScore(@PathVariable Long id,
	                                           @RequestParam Long score) {
	        return candidateAssessmentService.updateScore(id, score);
	    }

	    // Delete Assignment
	    @DeleteMapping("/{id}")
	    public String deleteAssignment(@PathVariable Long id) {
	        return candidateAssessmentService.deleteAssignment(id);
	    }

	}

