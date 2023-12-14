package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // method 위에 붙은 path보다 먼저 읽혀진다
@Controller    // Spring Bean으로 등록
public class Lesson01Ex01Controller {
	
	// url: http://localhost:8088/lesson01/ex01/1
	@ResponseBody // return 값을 response body에 넣어 출력 => HTML
	@RequestMapping("/1") // url path mapping
	public String ex01_1() {
		 return "<h2>예제1번</h2>문자열을 Response Body로 보내는 예제";
	}
	
	// url: http://localhost:8008/lesson01/ex01/2
	@ResponseBody
	@RequestMapping("/2")
	public Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 20);
		map.put("grape", 5);
		map.put("banana", 7);
		map.put("orange", 32);
		
		// {"키"=값} map
		// {"키":값} JSON, javascript dict
		
		// srping boot starter web (web starter) 안에 jackson이라는 라이브러리가 포함되어 있음
		// 그 라이브러리가 map이 response body에 담기면 json으로 자동 변환
		// = map을 return 하면 json으로 나타난다
		
		return map;
	}
		
}