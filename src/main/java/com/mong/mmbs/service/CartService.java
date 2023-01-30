package com.mong.mmbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.DeleteFromCartDto;
import com.mong.mmbs.dto.PutInCartDto;
import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.entity.CartEntity;
import com.mong.mmbs.repository.CartRepository;

@Service
public class CartService {
	  @Autowired
	    CartRepository cartRepository;
	  public ResponseDto<?> putInCart (PutInCartDto dto){
	    	
	    	String cartUserId = dto.getCartUserId();
	    	int cartProductId = dto.getCartProductId();
	    	String cartProductName = dto.getCartProductName();
	    	String cartProductImage = dto.getCartProductImage();
	    	int cartProductPrice = dto.getCartProductPrice();
	    	int cartProductAmount = dto.getCartProductAmount();
//	    	//중복을 찾아서 
//	    	if (cartEntity == null) {
//	    	}
//	    	CartEntity cartEntity = cartRepository.findByCartUserId(cartUserId);
	    	System.out.println(dto.toString());
	    	CartEntity cartEntity =null;
	    	cartEntity = new CartEntity(dto);
	    	cartRepository.save(cartEntity);
	    	return ResponseDto.setSuccess("장바구니에 담겼습니다.", null);
	    	

	    	}
	    public ResponseDto<?> deleteFromCart(DeleteFromCartDto dto){
	    	
	    	String cartUserId = dto.getCartUserId();
	    	int cartProductId = dto.getCartProductId();
	    	List<CartEntity> cartEntity = cartRepository.findByCartUserIdAndCartProductId(cartUserId, cartProductId);
	    	if(cartEntity != null) 
	    	cartRepository.deleteAll(cartEntity);
	    	return ResponseDto.setSuccess("장바구니에서 삭제되었습니다 .", null);
	    }
}
