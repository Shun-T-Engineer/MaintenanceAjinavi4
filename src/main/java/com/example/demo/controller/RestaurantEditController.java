package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Shop;
import com.example.demo.form.RestaurantEditForm;
import com.example.demo.service.RestaurantEditService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RestaurantEditController {
	
	private final RestaurantEditService service;
	
	@PostMapping("/show-edit-restaurant")
	public String showEditForm(@ModelAttribute RestaurantEditForm form) {
		System.out.println(form);
		return "edit-restaurant";
	}
	
	@PostMapping("/edit-restaurant")
	public String registShop(@Validated @ModelAttribute 
			RestaurantEditForm form, BindingResult result) {
		if(result.hasErrors()) {
			return "edit-restaurant";
			}
			
		return "confirm-edit-restaurant";
	}
	
	@PostMapping("/confirm-edit-restaurant")
	public String confirmRegistShop(@Validated RestaurantEditForm form,
															BindingResult result, 
															RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return "edit-restaurant";
		}
		
		Shop r = new Shop();
		r.setRestaurantId(form.getRestaurantId());
		r.setRestaurantName(form.getRestaurantName());
		r.setCatchPhrase(form.getCatchPhrase());
		
		service.edit(r);
		
		redirectAttributes.addFlashAttribute("msg", "お店を編集");
		
		return "redirect:/restaurant-edit-complete";
	}
	
	

}
