package com.example.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;

@Mapper
public interface UsedGoodsMapper {
	
	// input: x (BO에게 받음)
	// output: (DB의 query문을 실행해서) List<UsedGoods> (BO에 보냄)
	public List<UsedGoods> selectUsedGoodsList();
	
}
