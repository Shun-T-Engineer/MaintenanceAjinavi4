package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Restaurant;
import com.example.demo.entity.Shop;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ShopRepositoryImp implements ShopRepository {
	
	private final JdbcTemplate jdbcTemplate;

	
	@Override
	public void addShop(Shop shop) {
		String sql =
				"INSERT INTO m_restaurant" +
				"(restaurant_name, catch_phrase)" +
				"VALUES(?, ?)";
		
		jdbcTemplate.update(sql, shop.getRestaurantName(),
													 shop.getCatchPhrase() );
	}
	
	@Override
	public List<Restaurant> selectByNameWildcard(String restaurantName){
		
		
		String sql =
				" SELECT" +
				" mr.restaurant_id," +
				" mr.restaurant_name," +
				" mr.catch_phrase," +
				" COUNT(tr.rating)  review_count" +
				" FROM" +
				" m_restaurant mr" +
				" LEFT OUTER JOIN t_review tr" +
				" ON mr.restaurant_id = tr.restaurant_id" +
				" WHERE" +
				" mr.restaurant_name LIKE ?" +
				" GROUP BY" +
				" mr.restaurant_id," +
				" mr.restaurant_name," +
				" mr.catch_phrase" +
				" ORDER BY" +
				" mr.restaurant_id";
		
		String p = "%" + restaurantName + "%";
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, p);
		
		List<Restaurant> result = new ArrayList<Restaurant>();
		
		for(Map<String, Object> one: list) {
			Restaurant restaurant = new Restaurant();
			restaurant.setRestaurantId((int)one.get("restaurant_id"));
			restaurant.setRestaurantName((String)one.get("restaurant_name"));
			restaurant.setCatchPhrase((String)one.get("catch_phrase"));
			int raviewCount =((Long)one.get("review_count")).intValue();
			restaurant.setReviewCount(raviewCount);
			result.add(restaurant);
		}
		
		return result;
	}

	@Override
	public void update(Shop shop) {
		String sql = 
				" UPDATE" +
				" m_restaurant" +
				" SET" +
				" restaurant_name = ?," +
				" catch_phrase = ?" +
				" WHERE" +
				" restaurant_id = ?";
		
		jdbcTemplate.update(sql,
				shop.getRestaurantName(),
				shop.getCatchPhrase(),
				shop.getRestaurantId()				
				);
		
	}

	@Override
	public void delete(Shop shop) {
		String sql =
				" DELETE" +
				" FROM" +
				" m_restaurant" +
				" WHERE" +
				" restaurant_id = ?";
		
		jdbcTemplate.update(sql,shop.getRestaurantId());
		
	}

}
