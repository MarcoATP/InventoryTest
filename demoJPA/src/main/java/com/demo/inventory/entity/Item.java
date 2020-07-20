package com.demo.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.inventory.vo.ItemVO;

@Entity
@Table(name="item")
public class Item {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long no;
	
	@Column(name="name", nullable=false,length=50)
	private String name;
	
	@Column(name="amount", nullable=false )
	private Integer amount;
	
	@Column(name="inventoryCode", nullable=false)
	private String inventoryCode;
	
	public Item() {
		
	}
	
	public Item(ItemVO vo) {
		this.no = vo.getNo();
		this.name = vo.getName();
		this.amount = vo.getAmount();
		this.inventoryCode = vo.getInventoryCode();		
	}

	public ItemVO getVO() {
		ItemVO vo = new ItemVO();
		vo.setNo(this.no);
		vo.setName(this.name);
		vo.setAmount(this.amount);
		vo.setInventoryCode(this.inventoryCode);	
		
		return vo;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	@Override
	public String toString() {
		return "Item [no=" + no + ", name=" + name + ", amount=" + amount + ", inventoryCode=" + inventoryCode + "]";
	}
	
}
