package bartermall.service;

import java.util.List;

import bartermall.pojo.Product;
import bartermall.pojo.ProductWithUserInfo;

public interface ProductService {

	/**
	 ** 
	 * @Description://登录时候用的，当用户点头像，根据这个方法会返回用户发布了多少商品
	 * @param: @param uid
	 * @param: @return
	 * @return: List<Product>
	 */
	List<Product> getProductsByUserId(String uid);

	/**
	 ** 
	 * @Description://主页自动调取的方法，用户显示所有商品,
	 * @param: @return
	 * @return: List<Product>
	 */
	List<Product> getProductsAll();

	/*
	 * ，添加商品
	 */
	void addProduct(Product product);

	/**
	 ** 
	 * @Description:点击商品的时候查询商品详细信息
	 * @param: @param pid
	 * @param: @return
	 * @return: ProductWithUserInfo
	 */
	ProductWithUserInfo getProductWithUserInfoById(String pid);

	/**
	 ** 
	 * @Description:当用户点击后，增加商品浏览量
	 * @param: @param pid
	 * @return: void
	 */
	void addReadTimes(String pid);

	/**
	 * @Description: 模糊查询商品列表，就是用户点击搜索框的时候，查询显示到product_list.jsp页面。匹配的列是pdesc,与pname列 
	 * @param: @param keyword
	 * @param: @return
	 * @return: List<Product>
	 */
	List<Product> productSearch(String keyword);

	/**
	 **   
	 * @Description:查询所有在售商品
	 * @param: @return      
	 * @return: List<Product>      
	 */
	List<Product> getProductsAllOnsale();

	/**
	 **   
	 * @Description:根据商品分类查找（分为大类小类）
	 * @param: @param cid
	 * @param: @return      
	 * @return: List<Product>      
	 */
	List<Product> getProductListByCat(int cid);

	/**
	 **   
	 * @Description:查询所有商品并且排序（创建时间，信用，浏览量等）
	 * @param: @param urlValRank
	 * @param: @return      
	 * @return: List<Product>      
	 */
	List<Product> getProductsListOrderBy(String urlValRank);

	/**
	 **   
	 * @Description:刪除商品
	 * @param: @param pid      
	 * @return: void      
	 */
	void deleteProductByPid(String pid);

	/**
	 **   
	 * @Description:修改商品状态到已售
	 * @param: @param pid      
	 * @return: void      
	 */
	void editProductStateToYiSou(String pid); 
	
	/**
	 **   
	 * @Description:修改商品状态到未售
	 * @param: @param pid      
	 * @return: void      
	 */
	void editProductStateToWeiSou(String pid); 
}
