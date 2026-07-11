package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CandidateDTO;
import com.example.demo.entity.Candidate;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CandidateRepository;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    // Add Candidate
    public Candidate addCandidate(CandidateDTO dto) {

        Candidate candidate = new Candidate();

        candidate.setName(dto.getName());
        candidate.setEmail(dto.getEmail());

        return candidateRepository.save(candidate);
    }

    // Get All Candidates
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    // Get Candidate By Id
    public Candidate getCandidateById(Long candidate_id) {

        return candidateRepository.findById(candidate_id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate Not Found"));
    }

    // Update Candidate
    public Candidate updateCandidate(Long candidate_id, CandidateDTO dto) {

        Candidate candidate = candidateRepository.findById(candidate_id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate Not Found"));

        candidate.setName(dto.getName());
        candidate.setEmail(dto.getEmail());

        return candidateRepository.save(candidate);
    }

    // Delete Candidate
    public String deleteCandidate(Long candidate_id) {

        Candidate candidate = candidateRepository.findById(candidate_id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate Not Found"));

        candidateRepository.delete(candidate);

        return "Candidate Deleted Successfully";
    }

}