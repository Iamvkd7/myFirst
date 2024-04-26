package com.Shopping_Cart.Exception;

public class ShoopingCartItemException {

	private String messsage;

	public ShoopingCartItemException(String messsage) {
		super();
		this.messsage = messsage;
	}
	
	public String getMessage()
	{
		return messsage;
	}
}
