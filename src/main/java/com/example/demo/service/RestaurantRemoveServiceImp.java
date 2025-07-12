package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Shop;
import com.example.demo.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RestaurantRemoveServiceImp implements RestaurantRemoveService {

	private final ShopRepository repogitory;
	@Override
	public void remove(Shop shop) {
		repogitory.delete(shop);

	}

}
