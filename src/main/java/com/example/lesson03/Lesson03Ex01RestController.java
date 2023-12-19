package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// url: http://localhost:8008/lesson03/ex01
	// url: http://localhost:8008/lesson03/ex01?id=7
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
//			@RequestParam(value = "id")	int id   // 필수 param
//			@RequestParam(value = "id", required = true) int id   // 필수 param
//			@RequestParam(value = "id", required = false) Integer id    // 비필수 param = null인 경우를 아래에 따로 지정
//			@RequestParam(value = "id", defaultValue = "1") int id   // 비필수 param = null인 경우 1
			@RequestParam("id") int id) { // 필수 param
		// 필수 param일 때는 value를 생략하는 편이고, null이 가능하면 value를 적어야 함
		
//		if (id == null) {
//			id = 1;
//		}
		return reviewBO.getReviewById(id); // response body JSON
	}
	
}
