package bartermall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/*
 * 商品修改的controller：包括，擦亮，下架。删除，确认售出，商品修改
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bartermall.pojo.ProductWithUserInfo;
import bartermall.service.ProductService;
import bartermall.service.UserService;

@Controller
public class ProductEditController {
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;

	@RequestMapping("productSateEdit")
	@ResponseBody
	public String productSateEdit(HttpServletRequest request, HttpServletResponse response) {
		String pid = request.getParameter("pid");
		String flag = request.getParameter("flag");
		String res = "a";
		// 下架(删除)
		if (Integer.parseInt(flag) == 1) {
			productService.deleteProductByPid(pid);
			res = "aaa";
		}
		// 擦亮（增加用户积分）-所以只對主頁的根據信用查詢有效
		if (Integer.parseInt(flag) == 2) {
			ProductWithUserInfo productWithUserInfo 
			  = productService.getProductWithUserInfoById(pid);// 根據商品pid，得到商品所屬的用戶beloneto(所屬用戶)
			userService.addPointByReleaseProduct(productWithUserInfo.getBeloneto());//增加两积分
			res = "aaa";
		}
		// 售出（改变商品状态）
		if (Integer.parseInt(flag) == 3) {
			productService.editProductStateToYiSou(pid);
			ProductWithUserInfo productWithUserInfo 
			  = productService.getProductWithUserInfoById(pid);// 根據商品pid，得到商品与用户的信息)
			String userid=productWithUserInfo.getBeloneto();//得到用户id
			userService.addPointByReleaseProduct(userid);//增加两积分
			 res = "aaa";
		}
		// 上架（也是改变商品状态）state改成未售
		if (Integer.parseInt(flag) == 4) {
			productService.editProductStateToWeiSou(pid);
			 res = "aaa";
		}


		return res;
	}

}
