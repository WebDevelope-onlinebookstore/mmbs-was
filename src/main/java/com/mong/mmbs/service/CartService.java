package com.mong.mmbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.AmountUpdateDto;
import com.mong.mmbs.dto.DeleteAllFromCartDto;
import com.mong.mmbs.dto.DeleteFromCartDto;
import com.mong.mmbs.dto.PutInCartDto;
import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.dto.ShowInCartDto;
import com.mong.mmbs.entity.CartEntity;
import com.mong.mmbs.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	
	public ResponseDto<?> showInCart(String userId){
		List<CartEntity> cartEntity = cartRepository.findByCartUserId(userId);
		if(cartEntity==null) return ResponseDto.setFailed("장바구니에 담긴 상품이 없습니다."); 
		return ResponseDto.setSuccess("성공", cartEntity);
	}

	public ResponseDto<?> putInCart(PutInCartDto dto) {
		String cartUserId = dto.getCartUserId();
		int cartProductId = dto.getCartProductId();

		System.out.println(dto.toString());
		CartEntity cartEntity = cartRepository.findByCartUserIdAndCartProductId(cartUserId, cartProductId);
		if (cartEntity == null) {
			cartEntity = new CartEntity(dto);
			cartRepository.save(cartEntity);
			return ResponseDto.setSuccess("장바구니에 담겼습니다.", null);
		} else
			return ResponseDto.setFailed("장바구니에 이미 담겨 있습니다.");
//	    	{cartEntity = cartEntity.AmountUpdate(dto);
//	    		cartRepository.save(cartEntity);
	}

	public ResponseDto<?> deleteFromCart(DeleteFromCartDto dto) {

		String cartUserId = dto.getCartUserId();
		int cartProductId = dto.getCartProductId();
		CartEntity cartEntity = cartRepository.findByCartUserIdAndCartProductId(cartUserId, cartProductId);
		if (cartEntity != null)
			cartRepository.delete(cartEntity);
		return ResponseDto.setSuccess("장바구니에서 삭제되었습니다 .", null);
	}

	public ResponseDto<?> amountUpdate(AmountUpdateDto dto) {
		String cartUserId = dto.getCartUserId();
		int cartProductId = dto.getCartProductId();
		int cartProductAmount = dto.getCartProductAmount();
		CartEntity cartEntity = cartRepository.findByCartUserIdAndCartProductId(cartUserId, cartProductId);
//	    	cartEntity = cartEntity.AmountUpdate(dto);
		cartEntity.setCartProductAmount(cartProductAmount);
		cartRepository.save(cartEntity);
		return ResponseDto.setSuccess("장바구니에서 수정됬었습니다 .", null);
	}

	public ResponseDto<?> deleteAllFromCart(DeleteAllFromCartDto dto) {

		String cartUserId = dto.getCartUserId();
		
		List<CartEntity>cartEntity = cartRepository.findByCartUserId(cartUserId);
		if (cartEntity != null)
			cartRepository.deleteAll(cartEntity);
		return ResponseDto.setSuccess("장바구니에서 전부 삭제되었습니다 .", null);
	}
	public ResponseDto<?> cartAllAmount(DeleteAllFromCartDto dto) {

		String cartUserId = dto.getCartUserId();
			
		List<CartEntity>cartEntity = cartRepository.findByCartUserId(cartUserId);
		int total = 0;
		if (cartEntity != null){ 
			for (CartEntity cartEntity2 : cartEntity) {
			total +=cartEntity2.getCartProductAmount();
			}
		}
		
		return ResponseDto.setSuccess("장바구니에 담긴 책의 총수량", total);
	}
	public ResponseDto<?> cartTotalPrice(DeleteFromCartDto dto) {

		String cartUserId = dto.getCartUserId();
		int cartProductId = dto.getCartProductId();
			
		List<CartEntity>cartEntity = cartRepository.findByCartUserId(cartUserId);
		int price= 0;
		if (cartEntity != null){ 
			for (CartEntity cartEntity2 : cartEntity) {
				price =cartEntity2.getCartProductPrice()*cartEntity2.getCartProductAmount();
				}
		
		}
		return ResponseDto.setSuccess("장바구니에 담긴 책의 총 가격", null);
	}
}
