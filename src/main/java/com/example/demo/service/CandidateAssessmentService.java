package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CandidateAssessmentDTO;
import com.example.demo.entity.Assessment;
import com.example.demo.entity.Candidate;
import com.example.demo.entity.CandidateAssessment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssessmentRepository;
import com.example.demo.repository.CandidateAssessmentRepository;
import com.example.demo.repository.CandidateRepository;

@Service
public class CandidateAssessmentService {

    @Autowired
    private CandidateAssessmentRepository candidateAssessmentRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private AssessmentRepository assessmentRepository;

    // Assign Assessment to Candidate
    public CandidateAssessment assignAssessment(CandidateAssessmentDTO dto) {

        Candidate candidate = candidateRepository.findById(dto.getCandidate_id())
                .orElseThrow(() -> new ResourceNotFoundException("Candidate Not Found"));

        Assessment assessment = assessmentRepository.findById(dto.getAssessment_id())
                .orElseThrow(() -> new ResourceNotFoundException("Assessment Not Found"));

        CandidateAssessment assignment = new CandidateAssessment();

        assignment.setCandidate(candidate);
        assignment.setAssessment(assessment);
        assignment.setStatus(dto.getStatus());
        assignment.setScore(dto.getScore());

        // Calculate Result
        if (dto.getScore() >= assessment.getPassing_marks()) {
            assignment.setResult("Pass");
        } else {
            assignment.setResult("Fail");
        }

        return candidateAssessmentRepository.save(assignment);
    }

    // Get All Assignments
    public List<CandidateAssessment> getAllAssignments() {
        return candidateAssessmentRepository.findAll();
    }

    // Get Assignment By Id
    public CandidateAssessment getAssignmentById(Long assignmentId) {

        return candidateAssessmentRepository.findById(assignmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment Not Found"));
    }

    // Update Status
    public CandidateAssessment updateStatus(Long assignmentId, String status) {

        CandidateAssessment assignment = candidateAssessmentRepository.findById(assignmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment Not Found"));

        assignment.setStatus(status);

        return candidateAssessmentRepository.save(assignment);
    }

    // Update Score
    public CandidateAssessment updateScore(Long assignmentId, Long score) {

        CandidateAssessment assignment = candidateAssessmentRepository.findById(assignmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment Not Found"));

        assignment.setScore(score);

        if (score >= assignment.getAssessment().getPassing_marks()) {
            assignment.setResult("Pass");
        } else {
            assignment.setResult("Fail");
        }

        return candidateAssessmentRepository.save(assignment);
    }

    // Delete Assignment
    public String deleteAssignment(Long assignmentId) {

        CandidateAssessment assignment = candidateAssessmentRepository.findById(assignmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment Not Found"));

        candidateAssessmentRepository.delete(assignment);

        return "Assignment Deleted Successfully";
    }
}