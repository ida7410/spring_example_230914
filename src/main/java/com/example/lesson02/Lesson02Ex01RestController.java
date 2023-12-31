package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController
public class Lesson02Ex01RestController {
	
	@Autowired // DI: spring bean 주입
	private UsedGoodsBO usedGoodsBO;
	
	// url: http://localhost:8008/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		// service에게 내리기
		return usedGoodsBO.getUsedGoodsList(); // response => JSON
	}
	
}
