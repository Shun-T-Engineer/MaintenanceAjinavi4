package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Restaurant;
import com.example.demo.form.RestaurantRemoveForm;



@Controller
public class RemoveController {
	
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
		
		Restaurant r = new Restaurant();
		r.setRestaurantId(form.getRestaurantId());
		r.setRestaurantName(form.getRestaurantName());
		r.setCatchPhrase(form.getCatchPhrase());
		
		System.out.println("削除するキー一覧" + r);
		
		redirectAttributes.addFlashAttribute("msg", "レストラン削除");
		
		return "redirect:/complete";
	}
	
	
}
