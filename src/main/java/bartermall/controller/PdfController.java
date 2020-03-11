package bartermall.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import bartermall.common.util.PdfUtil;

/**
 * @Description:网页参考地址1：https://blog.csdn.net/top__one/article/details/65442390
 * 
 * @author: 唐涛
 * @date: 2020年3月11日 下午3:10:48 网页参考地址2
 *        https://blog.csdn.net/weixin_30361641/article/details/97371409?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
 * 
 */
@Controller
@RequestMapping("/pdf")
public class PdfController {

	/**
	 **   
	 * @Description:使用word生产pdf，再用abdoe给pdf设置表单域，再把pdf模板后台填充数据生成pdf，响应给前端
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: String      
	 */
	@RequestMapping("/testPdf")
	public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
		String json = request.getParameter("json");
		try {
			json = java.net.URLDecoder.decode(json, "UTF-8"); // 解码
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
           //JSONObject jsonObject = JSONObject.fromObject(json);
	      //  Map<String, Object> mapJson = JSONObject.fromObject(jsonObject);
		// Map mapJson = JSON.parseObject(json);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setCharacterEncoding("UTF-8");
		//得到模板所在路径
		String projectUrl = System.getProperty("user.dir");// 得到项目的路径
		String filePath = projectUrl + "\\src\\main\\webapp\\templatePDF\\pdf测试.pdf";
		Map<String, Object> mapJson=new HashMap<String, Object>();
		mapJson.put("userno", "541513140131");
		mapJson.put("username", "唐涛");
		mapJson.put("sex", "男");
		mapJson.put("birthday", "1997-05-09");
		mapJson.put("no", "411514199705094016");
		// 定义输出类型
		response.setContentType("application/PDF;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + "assessment.pdf");
		try {
			/*
			 * ①PrintWriter out=response.getWriter() out对象用于处理字符流数据。 ②ServletOutputStream
			 * os=response.getOutputStream(); os用于输出字符流数据或者二进制的字节流数据都可以。
			 */
			ServletOutputStream out = response.getOutputStream();
			PdfUtil pdf = new PdfUtil();
			pdf.fillTemplate(mapJson, out, filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
