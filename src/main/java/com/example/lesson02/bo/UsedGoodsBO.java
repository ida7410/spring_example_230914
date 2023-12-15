package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean으로 등록
public class UsedGoodsBO {
	
	@Autowired // Dependency injection(DI) = spring bean은 new를 할 수 없기 때문에 bean 가져오게 해줌
	private UsedGoodsMapper usedGoodsMapper; // spring bean을 가져온다
	
	// input = x (Controller에게 받아온다)
	// output = (Repo에게 받은) List<UsedGoods> (Controller에게 준다)
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsMapper.selectUsedGoodsList();
	}
	
}
