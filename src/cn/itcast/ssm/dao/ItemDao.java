package cn.itcast.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.ssm.po.Items;

public interface ItemDao {
	
	public void addItem(Items item) throws Exception;
	
	public void deleteItemById(Integer id) throws Exception;

	public void updateItem(Items item) throws Exception;
	
	public List<Items> queryItems() throws Exception;
	
	public Items getItemById(Integer id) throws Exception;

	public List<Items> queryItemsByPrice(@Param("startPrice") float startPrice, @Param("endPrice") float endPrice);

	
}
