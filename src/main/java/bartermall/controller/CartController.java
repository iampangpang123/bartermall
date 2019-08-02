package bartermall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bartermall.pojo.Cart;
import bartermall.pojo.CartItem;
import bartermall.pojo.Product;
import bartermall.service.CartService;

@Controller
public class CartController {
@Autowired
private CartService cartService; 

	@RequestMapping("addCart")
	public String addCart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		String pid=request.getParameter("pid");
		Product productInfo = cartService.findProductById(pid);
		CartItem cartItem=new CartItem();
		cartItem.setPid(productInfo.getPid());
		cartItem.setPname(productInfo.getPname());
		cartItem.setImage(productInfo.getPimage());
		cartItem.setPrice(productInfo.getSalePrice());
		cartItem.setCount(1);
		cartItem.setTotal(productInfo.getSalePrice());
		cart.add(cartItem);
		
		
	
		return "cartlist";
		
	}
	@RequestMapping("cleanCart")
	public String  cleanCart(HttpServletRequest request,HttpServletResponse response) {
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		cart.clear();
		return "cartlist";
	}
	@RequestMapping("deleteCartItem")
	public String  deleteCartItem(HttpServletRequest request,HttpServletResponse response) {
		String pid=request.getParameter("pid");
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		cart.delete(pid);
		return "cartlist";
	}
}
