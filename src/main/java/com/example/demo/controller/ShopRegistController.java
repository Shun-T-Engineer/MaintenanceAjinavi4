package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Shop;
import com.example.demo.form.ShopRegistForm;
import com.example.demo.service.ShopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShopRegistController {
	
	private final ShopService service;
	
	@GetMapping("/mt-top")
	public String mtTop() {
		return "mt-top";
	}
	
	@GetMapping("/show-regist-shop")
	public String showRegistShop(@ModelAttribute ShopRegistForm form) {
		return "show-regist-shop";
	}
	
	@PostMapping("/show-regist-shop-ret")
	public String showRegistShopRet(@ModelAttribute ShopRegistForm form) {
		return "show-regist-shop";
	}
	
	@PostMapping("/regist-shop")
	public String registShop(@Validated @ModelAttribute 
			                                   ShopRegistForm form, BindingResult result) {
		if(result.hasErrors()) {
			return "show-regist-shop";
			}
			
		return "confirm-regist-shop";
	}
	
	@PostMapping("/confirm-regist-shop")
	public String confirmRegistShop(@Validated ShopRegistForm form,
															BindingResult result, 
															RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return "show-regist-shop";
		}
		
		Shop r = new Shop();
		r.setRestaurantName(form.getRestaurantName());
		r.setCatchPhrase(form.getCatchPhrase());
		service.shopRegist(r);
		
		redirectAttributes.addFlashAttribute("msg", "お店を登録");
		
		return "redirect:/shop-regist-complete";
	}
	
	

}
