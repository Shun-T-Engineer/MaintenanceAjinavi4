package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping("/shop-regist-complete")
	private String shopRegistComplete() {
		return "shop-regist-complete";
	}
	
	@GetMapping("/restaurant-edit-complete")
	private String restaurantEditComplete() {
		return "restaurant-edit-complete";
	}
}
