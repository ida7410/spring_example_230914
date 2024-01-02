package com.example.lesson04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson04.domain.User;

@Repository
public interface UserMapper {

	// input: String name, String yyyymmdd, String email, String introduce
	// ouput: int 성공한 행의 개수
	public int insertUser(
			@Param("name") String name,
			@Param("yyyymmdd") String yyyymmdd,
			@Param("email") String email,
			@Param("introduce") String introduce);
	
	// input: x
	// ouput: User
	public User selectLatestUser();
	
	public boolean isDuplicatedByName(String name);

}
