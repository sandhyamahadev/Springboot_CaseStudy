package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "candidate")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Candidate {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long candidate_id;
	
	@Column (nullable = false)
	private String name;
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
	private List<CandidateAssessment> candidateAssessments;


}
