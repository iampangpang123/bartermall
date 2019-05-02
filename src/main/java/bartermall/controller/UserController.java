package bartermall.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bartermall.pojo.Product;
import bartermall.pojo.User;
import bartermall.service.ProductService;
import bartermall.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;

	/*
	 * 登录方法
	 */
	@RequestMapping("loginServlet")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		User user = new User();

		String res = null;
		PrintWriter out = response.getWriter();

		String userId = request.getParameter("uid");
		String flag = request.getParameter("flag");

		System.out.println(userId + "******" + flag + "校验前");
		// 校检登陆id
		if (Integer.parseInt(flag) == 1) {
			user = userService.getUserById(userId);
			if (user == null) {
				res = "aa";
			} else {
				res = "a";
			}

			response.setContentType("text/html;charset=utf-8");
			out.write(res);
		}
		// 校检密码
		System.out.println(userId + "******" + flag + "校验中");
		if (Integer.parseInt(flag) == 2) {
			String pwd = request.getParameter("pwd");
			User inputUser = new User();
			user.setId(userId);
			user.setPassword(pwd);
			user = userService.getUserByIdPwd(inputUser);
			if (user != null) {//
				res = "aa";
			} else {
				res = "a";
			}

			out.write(res);
		}
		System.out.println("******校验后");
		if (Integer.parseInt(flag) == 3) {
			String pwd = request.getParameter("pwd");

			User inputUser = new User();
			inputUser.setId(userId);
			inputUser.setPassword(pwd);
			//inputUser.setState("未认证");
			user = userService.getUserByIdPwd(inputUser);
			System.out.println(user);
			System.out.println(user + "33333");
			if (user != null) {

				request.getSession().setAttribute("user", user);
				// request.getRequestDispatcher("index.jsp").forward(request, response);
				response.sendRedirect("index.jsp");
				System.out.println("跳转到主页面");
			} else {
				System.out.println("跳转到登录界面");

				// request.setCharacterEncoding("utf-8");
//						request.setAttribute("uid", userId);
//						request.getRequestDispatcher("login.jsp").forward(request, response);
				response.sendRedirect("login.jsp");
			}

		}

	}

	/*
	 * 注册方法
	 */
	@RequestMapping("regServlet")
	public void regServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		User user = new User();
		String res = null;
		String flag = request.getParameter("flag");
		// 注册表单验证
		if (Integer.parseInt(flag) == 1) {
			String uid = request.getParameter("uid");
			user = userService.getUserById(uid);
			if (user != null) {
				res = "aaa";
			} else {
				res = "a";
			}
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			out.write(res);
		}

		// 用户注册
		if (Integer.parseInt(flag) == 2) {
			String photo = "avatar" + String.valueOf((int) (Math.random() * 8 + 1)) + ".png";
			String id = request.getParameter("userid");
			String pwd = request.getParameter("password");
			String qq = request.getParameter("qq");
			user.setPhoto(photo);
			user.setId(id);
			user.setPassword(pwd);
			user.setQq(qq);
            user.setState("未认证");
            user.setPoint(0);
			userService.regUser(user);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("user_center.jsp?id=" + id + "");
		}

		// response.sendRedirect("index.jsp");
		// request.setAttribute("name", "了几分动感");
		// request.getRequestDispatcher("index.jsp").forward(request, response);
	}


}
