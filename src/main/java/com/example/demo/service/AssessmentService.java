package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AssessmentDTO;
import com.example.demo.entity.Assessment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssessmentRepository;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    // Add Assessment
    public Assessment addAssessment(AssessmentDTO dto) {

        Assessment assessment = new Assessment();
        assessment.setTitle(dto.getTitle());
        assessment.setTechnology(dto.getTechnology());
        assessment.setDuration(dto.getDuration());
        assessment.setTotal_marks(dto.getTotal_marks());
        assessment.setPassing_marks(dto.getPassing_marks());

        return assessmentRepository.save(assessment);
    }

    // Get All Assessments
    public List<Assessment> getAllAssessement() {
        return assessmentRepository.findAll();
    }

    // Get Assessment By Id
    public Assessment getAssessmentById(Long assessment_id) {

        return assessmentRepository.findById(assessment_id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment Not Found"));
    }

    // Update Assessment
    public Assessment updateAssessment(Long assessment_id, AssessmentDTO dto) {

        Assessment assessment = assessmentRepository.findById(assessment_id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment Not Found"));

        assessment.setTitle(dto.getTitle());
        assessment.setTechnology(dto.getTechnology());
        assessment.setDuration(dto.getDuration());
        assessment.setTotal_marks(dto.getTotal_marks());
        assessment.setPassing_marks(dto.getPassing_marks());

        return assessmentRepository.save(assessment);
    }

    // Delete Assessment
    public String deleteAssessment(Long assessment_id) {

        Assessment assessment = assessmentRepository.findById(assessment_id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment Not Found"));

        assessmentRepository.delete(assessment);

        return "Assessment Deleted Successfully";
    }
}