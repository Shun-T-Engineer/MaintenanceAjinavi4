package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Shop;
import com.example.demo.form.RestaurantRemoveForm;
import com.example.demo.service.RestaurantRemoveService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class RemoveController {
	
	private final RestaurantRemoveService service;
	
	@PostMapping("/remove-restaurant")
	public String removeRestaurant(@Validated @ModelAttribute RestaurantRemoveForm form, BindingResult result)
	{
		if(result.hasErrors()) {
			throw new IllegalArgumentException("**removeReview()**");
		}
		
		return  "confirm-remove-restaurant";
	}
	
	@PostMapping("/confirm-remove-restaurant")
	public String confirmRemoveRestaurant(@Validated @ModelAttribute RestaurantRemoveForm form, BindingResult result,
																		RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			throw new IllegalArgumentException("**removeReview()**");
		}
		
		Shop r = new Shop();
		r.setRestaurantId(form.getRestaurantId());
		r.setRestaurantName(form.getRestaurantName());
		r.setCatchPhrase(form.getCatchPhrase());
		
		service.remove(r);
		
		redirectAttributes.addFlashAttribute("msg", "レストラン削除");
		
		return "redirect:/restaurant-remove-complete";
	}
	
	
}
