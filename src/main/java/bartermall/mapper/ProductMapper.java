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
	
	/**
	 **   
	 * @Description:模糊查询商品列表，就是用户点击搜索框的时候，查询显示到product_list.jsp页面。匹配的列是pdesc
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
	 * @Description:根据大类查找商品
	 * @param: @param cid
	 * @param: @return      
	 * @return: List<Product>      
	 */
	
	List<Product> getProductsListByBigCat(int cid);
	/**
	 **   
	 * @Description:根据小类查询商品信息
	 * @param: @param cid
	 * @param: @return      
	 * @return: List<Product>      
	 */
	List<Product> getProductsByListSmallCat(int cid);

	/**
	 **   
	 * @Description:查询所有商品并且排序（创建时间，热度（浏览量），价格等）
	 * @param: @param urlValRank
	 * @param: @return      
	 * @return: List<Product>      
	 */
	List<Product> getProductsListOrderByOther(String urlValRank);

	/**
	 **   
	 * @Description://因为积分设计到到多表查询。动态sql这个不行：没法使用多表查询
	 *              /根据信用查，就是用户的积分
	 * @param: @return      
	 * @return: List<Product>      
	 */
	List<Product> getProductsListOrderByPoint();

	/**
	 **   
	 * @Description:根據pid刪除商品
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
