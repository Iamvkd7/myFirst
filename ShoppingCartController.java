package com.Shopping_Cart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping_Cart.Entity.ShoppingCart;
import com.Shopping_Cart.Service.ShoppingCartService;
import com.Shopping_Cart.Structure.Utility.ResponseStructure;


@RestController
public class ShoppingCartController {
	@Autowired
	ShoppingCartService service;
	
	@PostMapping("/insert")
	public ResponseEntity<ResponseStructure<ShoppingCart>> Insert(@RequestBody ShoppingCart sc)
	{
		ResponseEntity<ResponseStructure<ShoppingCart>> insert = service.insert(sc);
		return insert;
	}
	
	@PostMapping("/insertAll")
	public ResponseEntity<ResponseStructure<ShoppingCart>> InsertAll(@RequestBody List<ShoppingCart> sc)
	{
		ResponseEntity<ResponseStructure<ShoppingCart>> insertAll = service.insertAll(sc);
		return insertAll;
	}
	
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> fetchById(@PathVariable int id)
	{
		ResponseEntity<ResponseStructure<ShoppingCart>> fetchById = service.fetchById(id);
		return fetchById;
	}
	@GetMapping("/fetchByItem/{itemName}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> fetchByItem(@PathVariable String itemName)
	{
		ResponseEntity<ResponseStructure<ShoppingCart>> fetchByItem = service.fetchByItem(itemName);
		return fetchByItem;
	}
	
	
	@PutMapping("/updateById/{cartId}/{itemName}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> updateCarById(@PathVariable int cartId, @PathVariable String itemName)
	{
		 ResponseEntity<ResponseStructure<ShoppingCart>> updateById = service.updateById(cartId, itemName);
		return updateById;
	}
	
	
	@PutMapping("/updateAll/{itemName}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> updateAll(@PathVariable String itemName)
	{
		ResponseEntity<ResponseStructure<ShoppingCart>> updateAll = service.updateAll(itemName);
		return updateAll;
	}
	
	
	@PutMapping("/updateByName/{itemName}/{noOfItems}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> updateCarByName(@PathVariable int noOfItems, @PathVariable String itemName)
	{
		 ResponseEntity<ResponseStructure<ShoppingCart>> updateById = service.updateByName(noOfItems, itemName);
		return updateById;
	}
	
	@DeleteMapping("/deleteById/{cartId}")
	public ResponseEntity<ResponseStructure<ShoppingCart>> deleteById(@PathVariable int cartId)
	{
		ResponseEntity<ResponseStructure<ShoppingCart>> deleteById = service.deleteById(cartId);
		return deleteById;
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<ResponseStructure<ShoppingCart>> deleleAll()
	{
		ResponseEntity<ResponseStructure<ShoppingCart>> deleteAll = service.deleteAll();
		return deleteAll;
	}
}
