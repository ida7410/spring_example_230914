package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	// 학생 추가 화면
	// http://localhost:8008/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// 방금 가입된 학생 화면 + db insert
	// http://localhost:8008/lesson04/ex02/add-student
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student, // 태그의 name 속성 param과 이름이 같은 field에 매핑
			// 하지만 대부분 @RequestParam으로 하나하나 받는 경우가 많음
			Model model) {
		
		// db insert
		studentBO.addStudent(student);
		
		// db에서 방금 가입된 사용자 select
		int id = student.getId();
		// selectStudentById
		Student latestStudent = studentBO.selectStudentById(id);
		
		// model에 담기
		model.addAttribute("student", latestStudent);
		
		// 테이블 꾸리기
		return "lesson04/afterAddStudent";
	}
	
}
