package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateAssessmentDTO {
	
	private Long assignment_id;
	private Long candidate_id;
	private Long assessment_id;
	private String status;
	private Long score;
	private String result;

}
