package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AssessmentDTO;
import com.example.demo.dto.CandidateDTO;
import com.example.demo.entity.Assessment;
import com.example.demo.entity.Candidate;
import com.example.demo.service.AssessmentService;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {
	
	@Autowired
	private AssessmentService assessmentService;
	
	//Add Assessment
	@PostMapping
	public Assessment addAssessment(@RequestBody AssessmentDTO dto) {
		return assessmentService.addAssessment(dto);
	}
	
	//Get All Assessments
	@GetMapping
	public List<Assessment> getAllAssessments() {
		return assessmentService.getAllAssessement();
}
	
	//Get Assessment By Id
	@GetMapping("/{id}")
	public Assessment getAssessmentById(@PathVariable Long id) {
		return assessmentService.getAssessmentById(id);
	}
	
	//Update Candidate
	@PutMapping("/{id}")
	public Assessment updateAssessment(@PathVariable Long id, @RequestBody AssessmentDTO dto) {
		return assessmentService.updateAssessment(id, dto);
	}
	
	//Delete Candidate
	@DeleteMapping("/{id}")
	public String deleteAssessment(@PathVariable Long id) {
		return assessmentService.deleteAssessment(id);
	}
}
