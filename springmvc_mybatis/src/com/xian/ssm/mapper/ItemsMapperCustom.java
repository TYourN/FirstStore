package com.xian.ssm.mapper;

import java.util.List;

import com.xian.ssm.model.ItemsCustom;
import com.xian.ssm.model.ItemsQueryVo;

public interface ItemsMapperCustom {
	//��Ʒ�Ĳ�ѯ�б�
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
