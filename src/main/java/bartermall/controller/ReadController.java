package bartermall.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("read")
public class ReadController {

	@RequestMapping("goodRule")
	public void goodRule(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String projectUrl = System.getProperty("user.dir");// 得到项目的路径
		String filePath = projectUrl + "\\src\\main\\webapp\\txt\\goodRule.txt";
		System.out.println(filePath);
		File file = new File(filePath);
		String str = "";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[512];
			int n;
			while ((n = fis.read(b)) != -1) {
				str = str + new String(b, 0, n);
				b = new byte[512];
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		Gson gson = new Gson();
//		String json = gson.toJson(str);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(str);
		//return str;
	}

	@RequestMapping("secondIphone")
	public void secondIpone(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String projectUrl = System.getProperty("user.dir");// 得到项目的路径
		String filePath = projectUrl + "\\src\\main\\webapp\\txt\\secondIphone.txt";
		System.out.println(filePath);
		File file = new File(filePath);
		String str = "";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[512];
			int n;
			while ((n = fis.read(b)) != -1) {
				str = str + new String(b, 0, n);
				b = new byte[512];
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		Gson gson = new Gson();
//		String json = gson.toJson(str);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(str);
		//return str;
	}
}
