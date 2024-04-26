package com.Shopping_Cart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Shopping_Cart.Entity.ShoppingCart;

import jakarta.transaction.Transactional;


@Repository
public interface ShoppingCartRepo extends CrudRepository<ShoppingCart,Integer>  {

	@Query("select sc from ShoppingCart sc where sc.itemName LIKE %?1%")
	public List<ShoppingCart> findByItemName(String itemName);
	

	@Modifying
	@Transactional
	@Query("UPDATE ShoppingCart sc SET sc.itemName = :itemName WHERE sc.cartId = :cartId")
	public int updateBycartId(@Param("cartId") int cartId, @Param("itemName") String itemName);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE ShoppingCart sc SET sc.itemName =:itemName")
	public int UpdateALLRecords(@Param("itemName") String itemName);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE ShoppingCart sc SET sc.noOfItems = :noOfItems WHERE sc.itemName = :itemName")
	public int updateBycartName(@Param("noOfItems") int noOfItems, @Param("itemName") String itemName);

}
