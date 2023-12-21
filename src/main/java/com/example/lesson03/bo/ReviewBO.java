package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	// 주석 추가
	
	// input: int id
	// output: Review (to Controller)
	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id);
	}
	
	// input: Review
	// ouput: int 성공한 행의 개수
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	// input: int storeId, String menu, String userName, Double point, String review
	// ouput: int 성공한 행의 개수
	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review) {
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	// input: int id, String review
	// ouput: int 성공한 행의 개수
	public int updateReviewById(int id, String review) {
			return reviewMapper.updateReviewById(id, review);
	}
	
	// input: int id
	// ouput: 
	public void deleteReviewById(int id) {
		reviewMapper.deleteReviewById(id);
	}
	
}
