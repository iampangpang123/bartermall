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
	@Override
	public List<Product> productSearch(String keyword) {
		// TODO Auto-generated method stub
		return productMapper.productSearch(keyword);
	}
	@Override
	public List<Product> getProductsAllOnsale() {
		// TODO Auto-generated method stub
		return productMapper.getProductsAllOnsale();
	}
	@Override
	public List<Product> getProductListByCat(int cid) {
		if(cid > 100){
			return productMapper.getProductsListByBigCat(cid);//根据大类查找山商品
		}else{
			return productMapper.getProductsByListSmallCat(cid);//根据小类查找商品
		}
	
	}
	@Override
	public List<Product> getProductsListOrderBy(String urlValRank) {
     if(urlValRank.equals("point")) {//因为积分设计到到多表查询。动态sql这个不行：没法使用多表查询
    	 return productMapper.getProductsListOrderByPoint();//根据信用查，就是用户的积分
    	
     }else {
    	 return productMapper.getProductsListOrderByOther(urlValRank);//这个动态sql(根据创建时间，浏览量，价格排序)
	}
	}
	@Override
	public void deleteProductByPid(String pid) {
	    productMapper.deleteProductByPid( pid);
	}
	@Override
	public void editProductState(String pid) {
		productMapper.editProductState(pid);
		
	}

}
