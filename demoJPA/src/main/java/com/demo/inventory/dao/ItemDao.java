package com.demo.inventory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.inventory.entity.Item;

public interface ItemDao extends JpaRepository<Item,Long>{

	@Query("select i from Item i order by i.no desc")
	List<Item> findItemsDescendingOrder();
}
