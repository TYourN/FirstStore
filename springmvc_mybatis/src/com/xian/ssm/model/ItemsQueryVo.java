package com.xian.ssm.model;

import java.util.List;

public class ItemsQueryVo {
	//��Ʒ��Ϣ
	private Items items;
	
	//Ϊ��ϵͳ�Ŀ���չ�ԣ���ԭ�����������չ
	private ItemsCustom itemsCustom;
	
	//������Ʒ��Ϣ
	private List<ItemsCustom> ItemsList;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	public List<ItemsCustom> getItemsList() {
		return ItemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		ItemsList = itemsList;
	}
	
	
}
