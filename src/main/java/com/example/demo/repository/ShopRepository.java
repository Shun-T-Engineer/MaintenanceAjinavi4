package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Restaurant;
import com.example.demo.entity.Shop;

public interface ShopRepository {
	void addShop(Shop shop);

	List<Restaurant> selectByNameWildcard(String restaurantName);
	
	void update(Shop shop);
	
	void delete(Shop shop);
}
