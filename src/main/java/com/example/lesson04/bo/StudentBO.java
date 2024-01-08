package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA로 insert
	public StudentEntity addStudent(
			String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) // @UpdateTimestamp가 있으면 생략가능 updatedAt도 마찬가지
				.build();
		
		return studentRepository.save(student); // 자동으로 id 채워줌
	}
	
	// JPA로 update
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// select
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// update = save
		if (student != null) {
			student = student.toBuilder() // 기존 필드값들은 유지하고 일부 필드만 변경
						.dreamJob(dreamJob)
						.build(); // 반드시 다시 저장!!!!!
			
			// update
			student = studentRepository.save(student);
		}
		
		return student; // student or null
	}
	
	// JPA로 delete
	public void deleteStudentById(int id) {
		// 1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 2)
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
	
	// Mybatis로 insert
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student selectStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
}
