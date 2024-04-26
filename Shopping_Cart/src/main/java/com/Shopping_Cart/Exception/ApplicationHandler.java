package com.Shopping_Cart.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Shopping_Cart.Entity.ShoppingCart;
import com.Shopping_Cart.Structure.Utility.ResponseStructure;

@RestControllerAdvice// whenever restcontroller used for cotroller class
//@ControllerAdvice
public class ApplicationHandler {
	
//	@ResponseBody
	public ResponseEntity<ResponseStructure<ShoppingCart>> CartNotFoundByItem(ShoopingCartItemException ie)
	{
		ResponseStructure<ShoppingCart> res = new ResponseStructure<>();
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		res.setMessage(ie.getMessage());
//		res.setData("Shopping_Cart Item Not Found");
		
		return new ResponseEntity<ResponseStructure<ShoppingCart>>(res,HttpStatus.NOT_FOUND);
	}

}
