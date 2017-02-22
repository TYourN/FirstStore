package com.xian.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xian.ssm.mapper.ItemsMapper;
import com.xian.ssm.mapper.ItemsMapperCustom;
import com.xian.ssm.model.Items;
import com.xian.ssm.model.ItemsCustom;
import com.xian.ssm.model.ItemsQueryVo;
import com.xian.ssm.service.ItemsService;


public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsMapperCustom itemsMapperCustom; 
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		// 通过ItemsMapperCustom来查询数据库	
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
		Items items=itemsMapper.selectByPrimaryKey(id);
		//接下来中间这里对商品信息进行业务的处理
		//......
		//返回ItemsCustom
		ItemsCustom itemsCustom=new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		// TODO Auto-generated method stub
		//添加业务的校验,通常在service接口中对关键参数进行校验
		//校验id是否为空，如果为空，则抛出异常
		
		//更新商品信息使用updateByPrimaryKeyWithBLOBs可以更新items表中所有字段，包括大文本类型。
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	
}
