package bartermall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bartermall.mapper.ProductMapper;
import bartermall.mapper.UserMapper;
import bartermall.pojo.Product;
import bartermall.pojo.ProductWithUserInfo;
import bartermall.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	@Override
	public List<Product> getProductsByUserId(String uid) {
		// TODO Auto-generated method stub
		return productMapper.getProductsByUserId(uid);
	}
	@Override
	public List<Product> getProductsAll() {
		
		return productMapper.getProductsAll();
	}
	@Override
	public void addProduct(Product product) {
		productMapper.addProduct(product);
		
	}
	@Override
	public ProductWithUserInfo getProductWithUserInfoById(String pid) {
		
		return productMapper.getProductWithUserInfoById(pid);
	}
	@Override
	public void addReadTimes(String pid) {
	productMapper.addReadTimes(pid);
		
	}

}
