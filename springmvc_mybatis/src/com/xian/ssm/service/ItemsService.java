package com.xian.ssm.service;

import java.util.List;

import com.xian.ssm.model.ItemsCustom;
import com.xian.ssm.model.ItemsQueryVo;

public interface ItemsService {
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据id来查询商品信息
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//修改商品信息
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception; 
	
	//批量删除商
}
