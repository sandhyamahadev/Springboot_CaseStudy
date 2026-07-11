package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "candidateassessment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateAssessment {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long assignment_id;
	
	@ManyToOne
	@JoinColumn( name = "candidate_id")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn( name = "assessment_id")
	private Assessment assessment;
	
	private String status;
	private Long score;
	private String result;

}
