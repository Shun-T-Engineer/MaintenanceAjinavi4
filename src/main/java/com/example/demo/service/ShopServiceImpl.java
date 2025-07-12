package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Shop;
import com.example.demo.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
	
	private final ShopRepository repository;

	@Override
	public void shopRegist(Shop shop) {
		repository.addShop(shop);

	}
}
