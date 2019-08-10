package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.Items;

public interface ItemService {

	public void addItem(Items item) throws Exception;
	
	public void deleteItemById(Integer id) throws Exception;

	public void updateItem(Items item) throws Exception;
	
	public List<Items> queryItems() throws Exception;
	
	public Items getItemById(Integer id) throws Exception;

	public List<Items> queryItemsByPrice(float startPrice, float endPrice);
}
