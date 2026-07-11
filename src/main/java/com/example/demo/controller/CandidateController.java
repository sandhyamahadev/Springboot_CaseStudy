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

import com.example.demo.dto.CandidateDTO;
import com.example.demo.entity.Candidate;
import com.example.demo.service.CandidateService;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
     
	@Autowired
	private CandidateService candidateService;
	
	//Add Candidate
	@PostMapping
	public Candidate addCandidate(@RequestBody CandidateDTO dto) {
		return candidateService.addCandidate(dto);
	}
	
	//Get All Candidates
	@GetMapping
	public List<Candidate> getAllCandidates() {
		return candidateService.getAllCandidates();
	}
	
	//Get candidate by Id
	@GetMapping("/{id}")
	public Candidate getCandidateById(@PathVariable Long id) {
		return candidateService.getCandidateById(id);
	}
	
	//Update Candidate
	@PutMapping("/{id}")
	public Candidate updateCandidate(@PathVariable long id, @RequestBody CandidateDTO dto) {
		return candidateService.updateCandidate(id, dto);
	}
	
	//Delete Candidate
	@DeleteMapping("/{id}")
	public String deleteCandidate(@PathVariable Long id) {
		return candidateService.deleteCandidate(id);
	}
}
