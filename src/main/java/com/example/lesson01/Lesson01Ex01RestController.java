package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponsBody
public class Lesson01Ex01RestController {

	// url: http://localhost:8008/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "@RestController 사용해 String을 return 해본다.";
	}

	// url: http://localhost:8008/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, Object> ex01_4() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("aaa", "1111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		
		return map; // -> json
	}
	
	// url: http://localhost:8008/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data(); // 일반 java bean
		data.setId(10);
		data.setName("신보람");
		
		return data; // 일반 bean 객체도 json으로 변환된다
	}
	
	// url: http://localhost:8008/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(11);
		data.setName("yoon");
		
		// HttpStatus 상태코드번호 = OK-200   InternalSE-500 etc
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); 
	}

}
