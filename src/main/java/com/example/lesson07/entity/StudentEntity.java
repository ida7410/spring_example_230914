package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 이 객체는 entity다.
@Table(name = "new_student")
@Getter
@Builder(toBuilder = true) // setter 대신 사용, toBuilder = true -> 필드값 변경 허용
@NoArgsConstructor // parameter가 없는 생성자
@AllArgsConstructor // parameter가 모두 있는 생성자
@ToString
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp // createdAt이 null이어도 현시간으로 저장
	@Column(name = "createdAt", updatable = false) // 업데이트시 변경되지 않도록 설정
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp // updatedAt이 null이어도 현시간으로 저장
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
