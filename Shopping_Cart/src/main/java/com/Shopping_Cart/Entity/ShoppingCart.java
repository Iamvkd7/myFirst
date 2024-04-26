package com.Shopping_Cart.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ShoppingCart {
	@Id
	private int cartId;
	private String itemName;
	private int noOfItems;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", itemName=" + itemName + ", NoOfItems=" + noOfItems + "]";
	}
	
	

}
