package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDTO {
	
	private Long assessment_id;
	private String title;
	private String technology;
	private String duration;
	private Long total_marks;
	private Long passing_marks;

}
