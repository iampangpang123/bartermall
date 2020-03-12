package bartermall.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bartermall.common.util.MyPDFUtil;

@Controller
public class PdfController {
	private static final Logger LOG = LoggerFactory.getLogger(PdfController.class);

	@ResponseBody
	@RequestMapping("/htmlToPDf")
	public void htmlToPdf(HttpServletRequest request, HttpServletResponse response) {
		String projectUrl = System.getProperty("user.dir");// 得到项目的路径
		String htmlTemplatePath = projectUrl + "\\src\\main\\webapp\\templatePDF\\htmlToPdf2.html";// 得到pdf模板路径
		Map<String, String> map = new HashMap<String, String>();
		map.put("###title###", "这是标11sssaaaaaaaaassssss111题");
		map.put("###author###", "我是作111111者们的身体就像一个城市，每个们的身体就像一个城市，每个");
		map.put("###content###", "我们的身体就像一个城市，每个细胞都是一幢城市中的大楼。大楼正常工作，才能维持身体正常机+\n" + "能aaaaaaaaaaaa。");
		map.put("###html###", "我们得身体就像一个城市");
		String result = MyPDFUtil.getStringFromHtml(htmlTemplatePath, map);// 得到处理后得result
		// 生成文件在本地
		MyPDFUtil.CoverHtmlToPdfWithNavicat("F:/JavaIO/tempController.html", "F:/JavaIO/tempController.pdf", result);

		// 输入文件直接给前端不保存在本地
		// 定义输出类型
		// response.setContentType("application/PDF;charset=utf-8");
		response.setContentType("application/x-download;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + "assessment.pdf");

		ServletOutputStream out = null;
		FileInputStream inputStream = null;

		try {
			out = response.getOutputStream();
			inputStream = new FileInputStream("F:/JavaIO/tempController.pdf");
			// 3.通过response获取ServletOutputStream对象(out)
			int b = 0;
			byte[] buffer = new byte[512];
			while (b != -1) {
				b = inputStream.read(buffer);
				// 4.写到输出流(out)中
				out.write(buffer, 0, b);
			}

		} catch (IOException e) {
			LOG.error("数组下标越界");
		} finally {
			try {
				out.flush();
				inputStream.close();
				out.close();
			} catch (Exception e) {
				LOG.error("数组下标越界");
			}
		}

		LOG.debug("调用controller接口生成pdf成功");

	}

	/**
	 ** 
	 * @Description:使用word生产pdf，再用abdoe给pdf设置表单域，再把pdf模板后台填充数据生成pdf，响应给前端
	 * @param: @param request
	 * @param: @param response
	 * @param: @return
	 * @return: String
	 * 
	 * 
	 * @Description:网页参考地址1：https://blog.csdn.net/top__one/article/details/65442390
	 * 
	 * @author: 唐涛
	 * @date: 2020年3月11日 下午3:10:48 网页参考地址2
	 *        https://blog.csdn.net/weixin_30361641/article/details/97371409?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
	 * 
	 *
	 */
	@RequestMapping("/pdfToPDf")
	public String pdfToPDf(HttpServletRequest request, HttpServletResponse response) {
		String json = request.getParameter("json");
		try {
			json = java.net.URLDecoder.decode(json, "UTF-8"); // 解码
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// JSONObject jsonObject = JSONObject.fromObject(json);
		// Map<String, Object> mapJson = JSONObject.fromObject(jsonObject);
		// Map mapJson = JSON.parseObject(json);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setCharacterEncoding("UTF-8");
		// 得到模板所在路径
		String projectUrl = System.getProperty("user.dir");// 得到项目的路径
		String filePath = projectUrl + "\\src\\main\\webapp\\templatePDF\\pdf测试.pdf";
		Map<String, Object> mapJson = new HashMap<String, Object>();
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
			// PdfUtil pdf = new PdfUtil();
			// pdf.fillTemplate(mapJson, out, filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
