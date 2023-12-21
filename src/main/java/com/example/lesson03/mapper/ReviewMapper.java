package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	// input: int id
	// output: Review (to BO)
	public Review selectReviewById(int id);
	
	// input: Review
	// ouput: 성공한 행의 개수
	public int insertReview(Review review);
	
	// input: addReviewAsField(int storeId, String menu, String userName, Double point, String review)
	// ouput:
	public int insertReviewAsField(
			@Param("storeId") int storeId
			,@Param("menu") String menu
			,@Param("userName") String userName
			,@Param("point") Double point
			,@Param("review") String review);
	
	// input: int id, String review
	// ouput: int 성공한 행의 개수
	public int updateReviewById(
			@Param("id") int id
			,@Param("review") String review);
	
	// input: int id
	// ouput: void
	public int deleteReviewById(int id);
	
}
