package com.example.test.temp.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/temp/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {
	
	@Autowired
	private UserBO userBO;
	
	@GetMapping("/add-user-view")
	public String addUserView() {
		return "temp/lesson06/ex02AddUser";
	}
	
	// check is duplicated - ajax request
	@ResponseBody
	@GetMapping("/is-duplicated-name")
	public Map<String, Object> isDuplicatedName(
			@RequestParam("name") String name) {
		
		boolean isDuplicated = userBO.isDuplicatedByName(name);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplicated", isDuplicated);
		
		return result;
	}
}
