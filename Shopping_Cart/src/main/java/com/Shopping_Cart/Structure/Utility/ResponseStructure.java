package com.Shopping_Cart.Structure.Utility;
import java.util.List;

import com.Shopping_Cart.Exception.ShoppingCartException;


public class ResponseStructure<T> {
	
	private int StatusCode;
	private String message;
	private T data;
	private List<T> l;
	
	private String exceptiondata;

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getL() {
		return l;
	}

	public void setL(List<T> l) {
		this.l = l;
	}

	public String getExceptiondata() {
		return exceptiondata;
	}

	public void setExceptiondata(String exceptiondata) {
		this.exceptiondata = exceptiondata;
	}
	
	


}
