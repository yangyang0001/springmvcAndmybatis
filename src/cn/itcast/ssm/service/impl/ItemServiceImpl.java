package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.dao.ItemDao;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.service.ItemService;

public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public void addItem(Items item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItemById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(Items item) throws Exception {
		// TODO Auto-generated method stub
		itemDao.updateItem(item);
	}

	@Override
	public List<Items> queryItems() throws Exception {
		return itemDao.queryItems();
	}

	@Override
	public Items getItemById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return itemDao.getItemById(id);
	}

	public ItemDao getItemDao() throws Exception {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) throws Exception {
		this.itemDao = itemDao;
	}

	@Override
	public List<Items> queryItemsByPrice(float startPrice, float endPrice) {
		return itemDao.queryItemsByPrice(startPrice,endPrice);
	}


}
