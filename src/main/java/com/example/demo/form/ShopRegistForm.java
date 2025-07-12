package com.example.demo.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShopRegistForm {
	private int restaurantId;
	
	@NotNull(message="入力してください")
	@Size(min=1, max=32, message="1文字から32文字で指定してください。")
	private String restaurantName;
	
	@NotNull(message="入力してください")
	@Size(min=1, max=64, message="1文字から64文字で指定してください。")
	private String catchPhrase;
}
