package bartermall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bartermall.mapper.CartMapper;
import bartermall.pojo.Product;
import bartermall.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;

	@Override
	public Product findProductById(String pid) {
		// TODO Auto-generated method stub
		return cartMapper.findProductById(pid);
	}

}
