package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Cart;

@Repository
public interface CartDAO {
	public boolean save(Cart cart);

	public boolean update(Cart cart);

	public boolean delete(Cart cart);
	

	public Cart getbyid(int id);
	
	public List<Cart> mycartproducts(String id);
	
	public int totalproducts(String id);

	public int totalprice(String id);
	
	public boolean orphanremoval(String id);
	
	public List<Cart> list();


}
