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
		// ͨ��ItemsMapperCustom����ѯ���ݿ�	
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
		Items items=itemsMapper.selectByPrimaryKey(id);
		//�������м��������Ʒ��Ϣ����ҵ��Ĵ���
		//......
		//����ItemsCustom
		ItemsCustom itemsCustom=new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		// TODO Auto-generated method stub
		//���ҵ���У��,ͨ����service�ӿ��жԹؼ���������У��
		//У��id�Ƿ�Ϊ�գ����Ϊ�գ����׳��쳣
		
		//������Ʒ��Ϣʹ��updateByPrimaryKeyWithBLOBs���Ը���items���������ֶΣ��������ı����͡�
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	
}
