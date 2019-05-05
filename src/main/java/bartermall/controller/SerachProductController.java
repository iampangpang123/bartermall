package bartermall.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bartermall.pojo.Product;
import bartermall.service.ProductService;

@Controller
public class SerachProductController {
	@Autowired
	private ProductService productService;

	/*
	 * 模糊查询商品列表，就是用户点击搜索框的时候，查询显示到product_list.jsp页面。匹配的列是pdesc
	 * 如果搜索框不是空的就调用这个
	 */
	@ResponseBody
	@RequestMapping("productSearch")
	public List<Product> productSearch(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("keyword");
		List<Product> list = productService.productSearch(keyword);
		System.out.println(list);
		return list;
	}
	/*
	 * 如果搜索框是空的就调用这个
	 */
	@ResponseBody
	@RequestMapping("findAllProductAndOrder")
	public List<Product> findAllProductAndOrder(HttpServletRequest request) throws Exception{
		List<Product> list = new ArrayList<>();
		String urlValCat = request.getParameter("cat");//这是搜索款下面的热门，（手机，笔记本）这些参数的分类。比如手机的分类是101.
		String urlValRank = request.getParameter("rank");//是点击排序方式的时候传递的参数，代表根据什么进行排序
		System.out.println("SearchController+*****+findAllProductAndOrder"+":::"+urlValCat.toString()+"****"+urlValRank.toString());
		System.out.println(urlValCat.length());
		//如果排序方式是空的，分类信息不是空的
		if ((urlValCat!=""&&!urlValCat.equals("")&&!"null".equals(urlValCat)||(urlValRank == ""&&urlValRank.equals("")&&"null".equals(urlValRank)))) {
			int cid=Integer.parseInt(urlValCat);
			if(cid == 0){
				list =productService.getProductsAllOnsale();//获取全部在售商品
			}else {
				list = 	productService.getProductListByCat(cid);//根据类别查询商品
			}
		}
		//如果分类信息是空的，排序不是空的
		if ((urlValCat==""&&urlValCat.equals("")&&"null".equals(urlValCat)||(urlValRank != ""&&!urlValRank.equals("")&&!"null".equals(urlValRank)))) {
			
			list = productService.getProductsListOrderBy(urlValRank);
		}
		
		if(urlValCat.equalsIgnoreCase("null")&&urlValRank.equalsIgnoreCase("null")) {
			list =productService.getProductsAllOnsale();//获取全部在售商品
		}
		
		return  list;
	}
}
