package com.Shopping_Cart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Shopping_Cart.Entity.ShoppingCart;
import com.Shopping_Cart.Exception.ShoppingCartException;
import com.Shopping_Cart.Repository.ShoppingCartRepo;
import com.Shopping_Cart.Structure.Utility.ResponseStructure;

@Service
public class ShoppingCartService {
	
	@Autowired
	ShoppingCartRepo repo;

	public ResponseEntity<ResponseStructure<ShoppingCart>> insert(ShoppingCart sc) {
		ShoppingCart save = repo.save(sc);
		
		if(save!=null) {
		ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
		resStr.setStatusCode(HttpStatus.CREATED.value());
		resStr.setMessage("Data Storred Successfully");
		resStr.setData(save);
		
		return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.CREATED);
	}
		else
		{
			ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
			resStr.setStatusCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
			resStr.setMessage("Data Not Storred ");
			resStr.setData(null);
			
			return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		}
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> insertAll(List<ShoppingCart> sc) {
		
		List<ShoppingCart> saveAll = (List<ShoppingCart>)repo.saveAll(sc);
		
		if(!saveAll.isEmpty()) {
			ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
			resStr.setStatusCode(HttpStatus.CREATED.value());
			resStr.setMessage("Data Storred Successfully");
			resStr.setL(saveAll);
			
			return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.CREATED);
		}
			else
			{
				ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
				resStr.setStatusCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
				resStr.setMessage("Data Not Storred");
				resStr.setData(null);
				
				return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
			}
		
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> fetchById(int id) {
		Optional<ShoppingCart> findById = repo.findById(id);
		ResponseStructure<ShoppingCart> resStr=null;
		if(findById.isPresent()) {
			ShoppingCart cart = findById.get();
		 resStr=new ResponseStructure<>();
			resStr.setStatusCode(HttpStatus.FOUND.value());
			resStr.setMessage("Data Found Successfully");
			resStr.setData(cart);
			
			return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.FOUND);
		}
			else
			{
				 resStr=new ResponseStructure<>();
				 ShoppingCartException exception = new ShoppingCartException("Item Not Found");
				 Class class1=exception.getClass();
				 String en=class1.getSimpleName();
				 
				resStr.setStatusCode(HttpStatus.NOT_FOUND.value());
				resStr.setMessage("shopping cart is not found");
				resStr.setExceptiondata(en);
				return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.NOT_FOUND);
			}
		
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> fetchByItem(String itemName){
		// TODO Auto-generated method stub
		List<ShoppingCart> findByItemName = repo.findByItemName(itemName);
		
		if(!findByItemName.isEmpty()) {
			ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
			resStr.setStatusCode(HttpStatus.FOUND.value());
			resStr.setMessage("Data Found Successfully");
			resStr.setL(findByItemName);
			
			return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.FOUND);
		}
			else
			{
				ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
				resStr.setStatusCode(HttpStatus.NOT_FOUND.value());
				resStr.setMessage("Data Not Found");
				resStr.setL(null);
				
				return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.NOT_FOUND);
			}
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> updateById(int cartId, String itemName) {
		// TODO Auto-generated method stub
	int updateBycartId = repo.updateBycartId(cartId, itemName);
		
		if(updateBycartId==1) {
			ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
			resStr.setStatusCode(HttpStatus.FOUND.value());
			resStr.setMessage("Data Updated Successfully");
			resStr.setData(null);
			
			return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.FOUND);
		}
			else
			{
				ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
				resStr.setStatusCode(HttpStatus.NOT_FOUND.value());
				resStr.setMessage("Data Not Update ");
				resStr.setData(null);
				
				return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.NOT_FOUND);
			}
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> updateAll(String itemName) {
		// TODO Auto-generated method stub
		int updateALLRecords = repo.UpdateALLRecords(itemName);
		if(updateALLRecords>1) {
			ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
			resStr.setStatusCode(HttpStatus.FOUND.value());
			resStr.setMessage("Data Updated Successfully");
			resStr.setData(null);
			
			return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.FOUND);
		}
			else
			{
				ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
				resStr.setStatusCode(HttpStatus.NOT_FOUND.value());
				resStr.setMessage("Data Not Update ");
				resStr.setL(null);
				
				return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.NOT_FOUND);
			}
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> updateByName(int noOfItems, String itemName) {
		int updateBycartName = repo.updateBycartName(noOfItems, itemName);
		
		if(updateBycartName==1) {
			ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
			resStr.setStatusCode(HttpStatus.FOUND.value());
			resStr.setMessage("Data Updated Successfully");
			resStr.setData(null);
			
			return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.FOUND);
		}
			else
			{
				ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
				resStr.setStatusCode(HttpStatus.NOT_FOUND.value());
				resStr.setMessage("Data Not Update ");
				resStr.setData(null);
				
				return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.NOT_FOUND);
			}
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> deleteById(int cartId) {
		// TODO Auto-generated method stub
		 repo.deleteById(cartId);
		 ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
			resStr.setStatusCode(HttpStatus.FOUND.value());
			resStr.setMessage("Data Deleted Successfully");
			resStr.setData(null);
			
			return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.FOUND);
		
	}

	public ResponseEntity<ResponseStructure<ShoppingCart>> deleteAll() {
		// TODO Auto-generated method stub
		repo.deleteAll();
		 ResponseStructure<ShoppingCart> resStr=new ResponseStructure<>();
			resStr.setStatusCode(HttpStatus.FOUND.value());
			resStr.setMessage("Data Deleted Successfully");
			resStr.setData(null);
			
			return new ResponseEntity<ResponseStructure<ShoppingCart>>(resStr,HttpStatus.FOUND);
	}

}
