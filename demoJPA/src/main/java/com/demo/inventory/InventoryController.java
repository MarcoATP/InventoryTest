package com.demo.inventory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.inventory.business.InventoryBusiness;
import com.demo.inventory.entity.Item;
import com.demo.inventory.vo.ItemVO;

@RestControllerAdvice
@CrossOrigin(origins = "*")
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired(required=true)
	private InventoryBusiness inventoryBusiness;
	
	@RequestMapping(value="items",method=RequestMethod.GET)
	public ResponseEntity<List<ItemVO>> selectAllItems(){
		System.out.println("no: ");
		List<ItemVO> items = inventoryBusiness.selectAllItems();
		return ResponseEntity.ok(items);
	}
	
	@RequestMapping(value="{itemNo}")
	public ResponseEntity<ItemVO> selectItemByNo(@PathVariable("itemNo") Long no){
		ItemVO item = inventoryBusiness.selectItemByNo(no);
		return ResponseEntity.ok(item);
	}
	
	@PostMapping(value="insertItem")
	public ResponseEntity<List<ItemVO>> insertItem(@RequestBody ItemVO item){
		return ResponseEntity.ok(inventoryBusiness.insertItem(item));
	}
	
	@PutMapping(value="updateItem")
	public ResponseEntity<List<ItemVO>> updateItemAmount(@RequestBody ItemVO item){
		return ResponseEntity.ok(inventoryBusiness.updateItem(item));
	}
	
	@DeleteMapping(value="{itemNo}")
	public ResponseEntity<List<ItemVO>> deleteItem(@PathVariable("itemNo") Long no){		
		return ResponseEntity.ok(inventoryBusiness.deleteItem(no));
	}
	
	@PutMapping(value="withdrawAmount")
	public ResponseEntity<List<ItemVO>> withdrawAmount(@RequestBody ItemVO item){		
		System.out.println(item.toString());
		return ResponseEntity.ok(inventoryBusiness.withdrawAmount(item));
	}
	
	@PutMapping(value="depositeAmount")
	public ResponseEntity<List<ItemVO>> depositeAmount(@RequestBody ItemVO item){		
		System.out.println(item.toString());
		return ResponseEntity.ok(inventoryBusiness.depositeAmount(item));
	}

}
