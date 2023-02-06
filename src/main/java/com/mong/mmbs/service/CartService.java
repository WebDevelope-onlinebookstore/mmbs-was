package com.mong.mmbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.AmountUpdateDto;
import com.mong.mmbs.dto.DeleteAllFromCartDto;
import com.mong.mmbs.dto.DeleteFromCartDto;
import com.mong.mmbs.dto.PutInCartDto;
import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.entity.CartEntity;
import com.mong.mmbs.entity.ProductEntity;
import com.mong.mmbs.repository.CartRepository;
import com.mong.mmbs.repository.ProductRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;

	public ResponseDto<?> showInCart(String userId) {
		List<CartEntity> cartEntity = cartRepository.findByCartUserId(userId);
		if (cartEntity == null)
			return ResponseDto.setFailed("장바구니에 담긴 상품이 없습니다.");
		return ResponseDto.setSuccess("성공", cartEntity);
	}

	// 장바구니 담기

	public ResponseDto<?> putInCart(PutInCartDto dto) {
		String cartUserId = dto.getCartUserId();
		int cartProductId = dto.getCartProductId();
		int cartProductAmount = dto.getCartProductAmount();

		ProductEntity productEntity = null;
		try {
			// 이부분 이해가 필요
			// productEntity/productRepository안에 cartproductId가 없는데 어떻게 넣는건지
			productEntity = productRepository.findByProductSeq(cartProductId);
			if (productEntity == null) {
				return ResponseDto.setFailed("실패");
			}

		} catch (Exception exception) {
			return ResponseDto.setFailed("데이터베이스 오류");
		}

		CartEntity cartEntity = null;
		try {
			// cartUserId, cartProductAmount이 두개만 엔터티에 넣는이유? 
			// 애초에 cart table db값에 안들어가있는상태가 아닌가??
			cartEntity = cartRepository.findByCartUserIdAndCartProductId(cartUserId, cartProductId);
		} catch (Exception exception) {
			return ResponseDto.setFailed("에러");
		}
		if (cartEntity == null) {

			// productEntity에 값들이 많은데 cartEntity안에 뭘넣는건지? 필드명들이 다 다른데
			cartEntity = new CartEntity(cartUserId, cartProductAmount, productEntity);

			try {
				cartRepository.save(cartEntity);
			} catch (Exception exception) {
				return ResponseDto.setFailed("error");
			}

		} else {
			cartEntity.setCartProductAmount(cartProductAmount);
			try {
				cartRepository.save(cartEntity);
			} catch (Exception exception) {
				return ResponseDto.setFailed("실패");
			}

		}
		// 얘역활을 모르겠음
		List<CartEntity> cartList = new ArrayList<CartEntity>();
		try {
			cartList = cartRepository.findByCartUserId(cartUserId);
		} catch (Exception exception) {
			return ResponseDto.setFailed("에러");
		}

		return ResponseDto.setSuccess("성공", cartList);

		// System.out.println(dto.toString());
		// CartEntity cartEntity =
		// cartRepository.findByCartUserIdAndCartProductId(cartUserId, cartProductId);
		// if (cartEntity == null) {
		// cartEntity = new CartEntity(dto);
		// cartRepository.save(cartEntity);
		// return ResponseDto.setSuccess("장바구니에 담겼습니다.", null);
		// } else
		// return ResponseDto.setFailed("장바구니에 이미 담겨 있습니다.");
		// {cartEntity = cartEntity.AmountUpdate(dto);
		// cartRepository.save(cartEntity);
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
		// cartEntity = cartEntity.AmountUpdate(dto);
		cartEntity.setCartProductAmount(cartProductAmount);
		cartRepository.save(cartEntity);
		return ResponseDto.setSuccess("장바구니에서 수정됬었습니다 .", null);
	}

	public ResponseDto<?> deleteAllFromCart(DeleteAllFromCartDto dto) {

		String cartUserId = dto.getCartUserId();

		List<CartEntity> cartEntity = cartRepository.findByCartUserId(cartUserId);
		if (cartEntity != null)
			cartRepository.deleteAll(cartEntity);
		return ResponseDto.setSuccess("장바구니에서 전부 삭제되었습니다 .", null);
	}

	public ResponseDto<?> cartAllAmount(DeleteAllFromCartDto dto) {

		String cartUserId = dto.getCartUserId();

		List<CartEntity> cartEntity = cartRepository.findByCartUserId(cartUserId);
		int total = 0;
		if (cartEntity != null) {
			for (CartEntity cartEntity2 : cartEntity) {
				total += cartEntity2.getCartProductAmount();
			}
		}

		return ResponseDto.setSuccess("장바구니에 담긴 책의 총수량", total);
	}

	public ResponseDto<?> cartTotalPrice(DeleteFromCartDto dto) {

		String cartUserId = dto.getCartUserId();
		int cartProductId = dto.getCartProductId();

		List<CartEntity> cartEntity = cartRepository.findByCartUserId(cartUserId);
		int price = 0;
		if (cartEntity != null) {
			for (CartEntity cartEntity2 : cartEntity) {
				price = cartEntity2.getCartProductPrice() * cartEntity2.getCartProductAmount();
			}

		}
		return ResponseDto.setSuccess("장바구니에 담긴 책의 총 가격", null);
	}
}
