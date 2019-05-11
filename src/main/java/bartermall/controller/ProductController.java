package bartermall.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bartermall.exception.GlobalException;
import bartermall.pojo.Product;
import bartermall.pojo.ProductWithUserInfo;
import bartermall.pojo.User;
import bartermall.service.ProductService;
import bartermall.service.UserService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	
	
	/**
	 **   
	 * @Description:用户点击某个商品，跳转到商品详情页
	 * @param: @param request
	 * @param: @param response      
	 * @return: void      
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("productInfo")
	public ProductWithUserInfo productInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String pid = request.getParameter("pid");
		System.out.println(pid);
		ProductWithUserInfo productWithUserInfo = productService.getProductWithUserInfoById(pid);
		productService.addReadTimes(pid);
		 return productWithUserInfo;
		//Gson gson = new Gson();
		//String json = gson.toJson(p);
		//System.out.println("ProductController+***"+"商品详情展示"+json.toString());
		
		//response.setCharacterEncoding("utf-8");
		//response.setContentType("application/json;charset=utf-8");
		//response.getWriter().write(json);	
	}

	/**
	 ** 
	 * @Description:主页自动调取的方法，显示所有商品
	 * @param: @param request
	 * @param: @param response
	 * @param: @throws IOException
	 * @return: void
	 */
	@RequestMapping("newProduct")
	public void newProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Product> list = null;
		try {
			list = productService.getProductsAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		/*
		 * 此法可以修改定义响应内容，比如返回json数据 response.setCharacterEncoding("utf-8");
		 * response.setContentType("application/json;charset=utf-8");
		 * response.getWriter().write("json串");
		 */
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/*
	 * 商品发布
	 */
	@RequestMapping("productrelease")
	public void productrelease(HttpServletRequest request, HttpServletResponse response, MultipartFile uploadFile)
			throws GlobalException, IOException{
		request.setCharacterEncoding("utf-8");
		String pname = request.getParameter("title");
		String pdesc = request.getParameter("desc");
		String buyPrice = request.getParameter("buyPrice");
		String salePrice = request.getParameter("salePrice");
		String cid2 = request.getParameter("catvalue");
		// String pid = request.getParameter("pid");
		String pid = UUID.randomUUID().toString().replace("-", "");
		System.out.println("pname" + pname + "pdesc" + pdesc + buyPrice + salePrice + "cid" + cid2 + pid);
		// 4. 设置图像（前提，springmvc要配置图片上传）
		// newimage：我们上传的图片暂时就在这个属性中.因为上传的图片的名字是newimage，所以我们这也要是newimage，这样参数绑定才能成功；
		// 不用image原是防止自动封装到user中
		// 原始文件名称
		String pictureFile_name = uploadFile.getOriginalFilename();
		// 要保存的路径，就是本项目下面的bank_img这个文件夹的路径
		String savePath = request.getServletContext().getRealPath("/imgs_products/");// 要保存的路径
		System.out.println("savePath" + savePath);
		// 新文件名称
		String newFileName = UUID.randomUUID().toString().replace("-", "").trim()
				+ pictureFile_name.substring(pictureFile_name.lastIndexOf("."));// 就是新图片id加上后面的扩展名
		System.out.println("newFileName" + newFileName);
		// 新文件
		File newFile = new File(savePath, newFileName);
		// 写入文件
		// 2.图片路径设置到user中
		// user.setImage("img/headphoto/" + newFileName);
		try {
			uploadFile.transferTo(newFile);
			request.setAttribute("message", "文件上传成功!");
		} catch (Exception e) {
			request.setAttribute("message", "错误信息: " + e.getMessage());
		}
		User user = (User) request.getSession().getAttribute("user");
		// 保存上面的图片路径
		String pimage = "/imgs_products/" + newFileName;
		System.out.println("pname" + pname + "pdesc" + pdesc + buyPrice + salePrice + "cid" + cid2 + "pid" + pid
				+ "pimage" + pimage);
		//补上发布时间，根据这个排序
        SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss "); 

        String creattime = sdf.format(new Date()); 
		Product product = new Product(pid, pname, Double.parseDouble(buyPrice), Double.parseDouble(salePrice), pdesc,
				pimage, user.getId(), Integer.parseInt(cid2), 0, "在售", "否", creattime);
		// 调用service保存
		productService.addProduct(product);
		userService.addPointByReleaseProduct(user.getId());
		System.out.println("add:" + product);
		String url = "user_center.jsp?id=" + user.getId();
		response.sendRedirect(url);
	}


}
