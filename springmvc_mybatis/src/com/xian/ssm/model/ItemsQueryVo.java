package com.xian.ssm.model;

import java.util.List;

public class ItemsQueryVo {
	//商品信息
	private Items items;
	
	//为了系统的可扩展性，对原生的类进行扩展
	private ItemsCustom itemsCustom;
	
	//批量商品信息
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
