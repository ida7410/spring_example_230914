package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// JSP로 보내는 controller
@Controller // ResponseBody가 있으면 안 된다!!!(@RestController X)
public class Lesson01Ex02Controller {
	
	// url: http://localhost:8008/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		// return 되는 String은 jsp의 경로이다. (@ResponseBody가 없을 때) = response view의 경로
//		return "/WEB-INF/jsp/lesson01/ex02.jsp";
		// application.properties 에 prefiex(/WEB-INF/jsp/)와 surfix(.jsp)를 설정해두었기 때문에 전부 제외한 lesson01/ex02만
		// 위 설정을 안 해두면 WEB-INF와 그 아래 폴더는 같이 써야 함

		return "lesson01/ex02";
	}
	
}
