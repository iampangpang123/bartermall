package bartermall.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import bartermall.pojo.Product;
import bartermall.pojo.User;
import bartermall.service.ProductService;
import bartermall.service.UserService;

@Controller
public class EditUserInfoController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	
	
	/*
	 * 添加用户头像
	 */
	@RequestMapping("editUserImage")
	public void editUserImage(HttpServletRequest request,HttpServletResponse response,MultipartFile uploadFile) throws IOException {
		// 4. 设置图像（前提，springmvc要配置图片上传）
		// newimage：我们上传的图片暂时就在这个属性中.因为上传的图片的名字是newimage，所以我们这也要是newimage，这样参数绑定才能成功；
		// 不用image原是防止自动封装到user中
		// 原始文件名称
		String pictureFile_name = uploadFile.getOriginalFilename();
		// 要保存的路径，就是本项目下面的bank_img这个文件夹的路径
		String savePath = request.getServletContext().getRealPath("/imgs/");// 要保存的路径
		System.out.println("savePath" + savePath);
		// 新文件名称
		String newFileName = UUID.randomUUID().toString().replace("-", "").trim()
				+ pictureFile_name.substring(pictureFile_name.lastIndexOf("."));// 就是新图片id加上后面的扩展名
		System.out.println("newFileName" + newFileName);
		// 新文件
		File newFile = new File(savePath, newFileName);
		// 写入文件
		// 2.图片路径设置到user中
		User user=(User) request.getSession().getAttribute("user");
		System.out.println(user);
		user.setPhoto(newFileName);
		//更新注册状态
		user.setState("已认证");
		//3.调用service保存
		userService.updateUserPhoto(user);
		try {
			uploadFile.transferTo(newFile);
			request.setAttribute("message", "文件上传成功!");
		} catch (Exception e) {
			request.setAttribute("message", "错误信息: " + e.getMessage());
		}
		String url = "user_center.jsp?id="+user.getId();
		response.sendRedirect(url);
		
	}
	
	/*
	 * 点击用户头像进入用户首页
	 */
	@RequestMapping("userServlet")
	public void userServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		String uid = request.getParameter("uid");
		Gson gson = new Gson();
		String json = null;

		if (Integer.parseInt(flag) == 1) {
			User user = userService.getUserById(uid);
			json = gson.toJson(user);
			System.out.println("USerServlet::::"+"userJson:::"+json.toString());

		}
		if (Integer.parseInt(flag) == 2) {
			System.out.println(uid);
			List<Product> list = productService.getProductsByUserId(uid);
			System.out.println(list);
			json = gson.toJson(list);
			System.out.println("USerServlet::::"+"Productlist:::"+json.toString());

		}
		response.getWriter().write(json);

	}

	/**
	 * 用戶補全信息
	 * @throws IOException 
	 */
	@RequestMapping("useredit")
	public void useredit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String qq = request.getParameter("qq");
		String college = request.getParameter("college");
		String grade = request.getParameter("grade");
		String area = request.getParameter("area");
		user.setName(name);
		user.setTel(tel);
		user.setQq(qq);
		user.setCollege(college);
		user.setGrade(grade);
		user.setArea(area);
		//user.setState("未认证");
		userService.updateUserInfo(user);

		String resp = "更新成功!";
		Gson gson = new Gson();
		String json = gson.toJson(resp);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
	}
	/*
	 * 推出登录
	 */
	@RequestMapping("quitLogin")
	public String quitLogin(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "index";
		
	}
}
