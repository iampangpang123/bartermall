package bartermall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bartermall.pojo.Product;
import bartermall.pojo.User;
import bartermall.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("adminFindListUser")
	public String adminFindListUser(Model model) {
		List<User> findUserList = adminService.findUserList();

		model.addAttribute("userList", findUserList);
		return "adminjsps/admin/user/list";
	}
	@RequestMapping("adminFindListProducts")
	public String adminFindListProducts(Model model) {
	 List<Product> findProductsList = adminService.findProductsList();

		model.addAttribute("findProductsList", findProductsList);
		return "adminjsps/admin/products/list";
	}
}
