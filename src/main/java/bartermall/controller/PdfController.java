package bartermall.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import bartermall.common.util.PdfUtil;


@Controller
public class PdfController {

	@RequestMapping("/testPdf")
	public String  downloadFile(HttpServletRequest request ,HttpServletResponse response){
		String json =request.getParameter("json");
	        try {
				json = java.net.URLDecoder.decode(json,"UTF-8");  //解码
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//	        JSONObject jsonObject = JSONObject.fromObject(json);
//	        Map<String, Object> mapJson = JSONObject.fromObject(jsonObject);
	        Map mapJson = JSON.parseObject(json);  
	    	// 设置response参数，可以打开下载页面
	        response.reset();
	        response.setCharacterEncoding("UTF-8");
	        // 定义输出类型
	        response.setContentType("application/PDF;charset=utf-8");
	        response.setHeader("Content-Disposition", "attachment; filename=" + "assessment.pdf");
	        try {
				ServletOutputStream out = response.getOutputStream();
				PdfUtil pdf = new PdfUtil();
			    pdf.fillTemplate(mapJson ,out,"模板pdf存放的路径");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }

}
