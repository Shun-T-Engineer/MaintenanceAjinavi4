package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Shop;
import com.example.demo.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantEditServiceImpl implements RestaurantEditService {
	
	private final ShopRepository repository;

	@Override
	public void edit(Shop shop) {
		repository.update(shop);

	}

}
