package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController

public class Lesson03Ex02RestController {
	
	@Autowired
	private ReviewBO reviewBO;

	// http://localhost:8008/lesson03/ex02
	@RequestMapping("/lesson03/ex02")
	public String ex02() {
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("윤현빈");
		review.setPoint(4.5);
		review.setReview("따뜻해서 맛있어요");
		
		// insert 후 성공한 row 수를 return
		int rowCount =  reviewBO.addReview(review);
		
		return "성공한 행의 개수: " + rowCount;
	}
	
	// http://localhost:8008/lesson03/ex02/1
	@RequestMapping("/lesson03/ex02/1")
	public String ex02_1() {
		int rowCount = reviewBO.addReviewAsField(4, "콤비네이션R", "윤현빈", 5.0, "정말 맛있었어요");
		return "성공한 행의 개수: " + rowCount;
	}

}
