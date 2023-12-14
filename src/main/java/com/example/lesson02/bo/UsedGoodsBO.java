package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // spring bean으로 등록
public class UsedGoodsBO {
	
	// input = x (Controller에게 받아온다)
	// output = (Repo에게 받은) List<UsedGoods> (Controller에게 준다)
	public List<UsedGoods> getUsedGoodsList() {
		return ;
	}
	
}
