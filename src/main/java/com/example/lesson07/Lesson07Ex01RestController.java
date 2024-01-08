package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// c: create
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "윤현빈";
		String phoneNumber = "01085725413";
		String email = "ida.yoonh741@gmail.com";
		String dreamJob = "개발자";
		
		// 방금 insert된 pk id도 바로 얻어낼 수 있음
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	
	// u: update
	@GetMapping("/2")
	public StudentEntity update() {
		// id가 5번인 dreamJob 작가 변경
		return studentBO.updateStudentDreamJobById(5, "작가");
	}
	
	
	// d: delete
	@GetMapping("/3")
	public String delete() {
		// id: 5
		studentBO.deleteStudentById(5);
		
		return "삭제 완료";
	}
	
}
