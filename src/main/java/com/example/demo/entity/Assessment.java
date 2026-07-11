package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table (name = "assessment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assessment {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long assessment_id;
	
	private String title;
	private String technology;
	private String duration;
	private Long total_marks;
	private Long passing_marks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL)
	private List<CandidateAssessment> candidateAssessments;
	
}
