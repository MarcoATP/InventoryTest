package com.demo.inventory.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.inventory.dao.ItemDao;
import com.demo.inventory.entity.Item;
import com.demo.inventory.vo.ItemVO;

@Component
public class InventoryBusiness {
	
	@Autowired
	private ItemDao itemDao;
	
	public List<ItemVO> selectAllItems(){
		List<Item> items = itemDao.findAll();
		List<ItemVO> result = new ArrayList<ItemVO>();
		
		items.forEach(it-> result.add(it.getVO()));		
		return result;
	}
	
	public ItemVO selectItemByNo(Long no){
		Optional<Item> item = itemDao.findById(no);		
		ItemVO result = item.isPresent() ? item.get().getVO() : null;		
		return result;
	}
	
	public List<ItemVO> insertItem(ItemVO vo){
		
		List<Item> items = itemDao.findItemsDescendingOrder();
		Item item = items.get(0);
		
		vo.setNo(item.getNo()+1);
		System.out.println("ENTIDAD : " + item.toString());
		itemDao.save(new Item(vo));
		
		return selectAllItems();	
	}
	
	public List<ItemVO> updateItemAmount(Long no, Integer amountDiscount){
		Optional<Item> itemOp = itemDao.findById(no);
		Item item = itemOp.get();
		
		Integer newAmount = item.getAmount() - amountDiscount;
		item.setAmount(newAmount);
		
		itemDao.save(item);
		
		return selectAllItems();	
	}
	
	public List<ItemVO> updateItem(ItemVO itemParam){
		Optional<Item> itemOp = itemDao.findById(itemParam.getNo());
		Item item = itemOp.get();

		item.setName(itemParam.getName());
		item.setAmount(itemParam.getAmount());
		item.setInventoryCode(itemParam.getInventoryCode());
		
		itemDao.save(item);
		
		return selectAllItems();	
	}
	
	public List<ItemVO> deleteItem(Long no){		
		itemDao.deleteById(no);		
		return selectAllItems();
	}
	
	public List<ItemVO> withdrawAmount(ItemVO item){	
		Optional<Item> itemOp = itemDao.findById(item.getNo());
		
		Item entity = itemOp.get();
		entity.setAmount(item.getAmount() - item.getAmountModifier());
		itemDao.save(entity);	
		return selectAllItems();
	}
	
	public List<ItemVO> depositeAmount(ItemVO item){
		Optional<Item> itemOp = itemDao.findById(item.getNo());
		
		Item entity = itemOp.get();
		entity.setAmount(item.getAmount() + item.getAmountModifier());
		itemDao.save(entity);	
		return selectAllItems();
	}

}
