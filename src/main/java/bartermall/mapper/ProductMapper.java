package bartermall.mapper;

import java.util.List;

import bartermall.pojo.Product;
import bartermall.pojo.ProductWithUserInfo;

public interface ProductMapper {
	/**
	 **   
	 * @Description:点击用户首页的时候调取的方法，展示用户发布的方法
	 * @param: @param uid
	 * @param: @return      
	 * @return: List<Product>      
	 */
	List<Product> getProductsByUserId(String uid);
	
	/**
	 **   
	 * @Description:登录主页自动调取的方法，用来显示所有商品信息
	 * @param: @return      
	 * @return: List<Product>      
	 */
	List<Product> getProductsAll();

	void addProduct(Product product);//添加商品的方法

	/**
	 **   
	 * @Description:点击商品的时候，得到商品的详细信息与用户的详细信息
	 * @param: @return      
	 * @return: ProductWithUserInfo      
	 */
	ProductWithUserInfo getProductWithUserInfoById(String pid);

	/**
	 **   
	 * @Description:增加某个商品浏览量的方法
	 * @param: @param pid      
	 * @return: void      
	 */
	void addReadTimes(String pid);
}
