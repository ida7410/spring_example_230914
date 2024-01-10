package com.example.lesson07;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RestController
@RequestMapping("/lesson07/ex02")
public class Lesson07Ex02RestController {
	
	// !!!!이번에만 BO 생략!!!
	@Autowired
	private StudentRepository studentRepository;
	
	// 조회하는 여러가지 방법
	@GetMapping("/1")
	public List<StudentEntity> getStudentList() {
		// 1. 전체 조회(기본 제공 method)
//		return studentRepository.findAll();
		
		// 2. id 기준 내림차순 전체 조회 = order by
//		return studentRepository.findAllByOrderByIdDesc();
		
		// 3. id 기준 내림차순 3개만 조회 = order by limit
//		return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4. 이름 '윤현빈' 조회 = where
//		return studentRepository.findByName("윤현빈");
		
		// 5. in문으로 일치하는 값 모두 조회 = in
//		return studentRepository.findByNameIn(Arrays.asList("윤현빈"));
		
		// 6. 여러 col 값과 일치하는 데이터 조회(이름, 장래희망) = where and
//		return studentRepository.findByNameAndDreamJob("윤현빈", "개발자");
		
		// 7. email col에 gmail 포함된 데이터 조회 = like %gmail%
//		return studentRepository.findByEmailContaining("gmail");
		
		// 8. 이름이 윤으로 시작하는 데이터 조회 = like 윤%
//		return studentRepository.findByNameStartingWith("윤");
		
		// 9. id가 1 ~ 5 인 데이터 조회 = between
		return studentRepository.findByIdBetween(1, 5);
	}
	
	@GetMapping("/2")
	public List<StudentEntity> getStudent() {
		// 장래희망이 '개발자'인 데이터 조회
		return studentRepository.findByDreamJob("개발자");
	}
	
}
