package com.example.lesson03.mapper;

import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	// input:
	// output: Review (to BO)
	public Review selectReviewById();
	
}
