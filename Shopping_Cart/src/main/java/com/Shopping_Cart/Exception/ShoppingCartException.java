package com.Shopping_Cart.Exception;


public class ShoppingCartException extends Exception {
	
	private String message;
	
	public ShoppingCartException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}

}
