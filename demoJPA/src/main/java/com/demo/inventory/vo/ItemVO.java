package com.demo.inventory.vo;

import java.io.Serializable;

public class ItemVO implements Serializable{

	private Long no;
	private String name;
	private Integer amount;
	private String inventoryCode;
	private Integer amountModifier;
	
	public ItemVO() {
		
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

	public Integer getAmountModifier() {
		return amountModifier;
	}

	public void setAmountModifier(Integer amountModifier) {
		this.amountModifier = amountModifier;
	}

	@Override
	public String toString() {
		return "ItemVO [no=" + no + ", name=" + name + ", amount=" + amount + ", inventoryCode=" + inventoryCode
				+ ", amountModifier=" + amountModifier + "]";
	}
	
	
}
