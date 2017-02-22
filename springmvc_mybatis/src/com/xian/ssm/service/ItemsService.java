package com.xian.ssm.service;

import java.util.List;

import com.xian.ssm.model.ItemsCustom;
import com.xian.ssm.model.ItemsQueryVo;

public interface ItemsService {
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//����id����ѯ��Ʒ��Ϣ
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//�޸���Ʒ��Ϣ
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception; 
	
	//����ɾ����
}
