package com.niit.shoppingcart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int quantity;
	private int price;
	@ManyToOne
	@JoinColumn(name = "user_Id", insertable = false, updatable = false)
	private UserDetails cartuser;
	private String user_Id;
	
	@ManyToOne
	@JoinColumn(name = "prod_Id", insertable = false, updatable = false)
	private Product cartproduct;
	private String prod_Id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public UserDetails getCartuser() {
		return cartuser;
	}
	public void setCartuser(UserDetails cartuser) {
		this.cartuser = cartuser;
	}
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public Product getCartproduct() {
		return cartproduct;
	}
	public void setCartproduct(Product cartproduct) {
		this.cartproduct = cartproduct;
	}
	public String getProd_Id() {
		return prod_Id;
	}
	public void setProd_Id(String prod_Id) {
		this.prod_Id = prod_Id;
	}
	
	
	

	

    
    

}
