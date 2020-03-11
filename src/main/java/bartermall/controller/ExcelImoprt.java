package bartermall.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;


@Controller
public class ExcelImoprt {

	@RequestMapping("excelImport")
	public void excelImport(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int count = 60;
		// 读取excel模板
		FileInputStream inStream = new FileInputStream(new File("F:\\JavaIO\\文化事业应税服务扣除清单.xls"));
		HSSFWorkbook wb = new HSSFWorkbook(inStream);
		// 读取了模板内所有sheet内容
		HSSFSheet sheet = wb.getSheet("应税服务减除项目清单");
		for (int i = 4; i < 10; i++) {
			HSSFRow row = sheet.createRow(i);// 第5行開始記錄，下次遍歷開始count++

			HSSFCell cell0 = row.createCell(0);// 第一个单元格，下表从0开始。
			cell0.setCellValue("222");

			HSSFCell cell1 = row.createCell(1);// 第二个单元格
			cell1.setCellValue("222");

			HSSFCell cell2 = row.createCell(2);// 第3个单元格
			cell2.setCellValue("222");

			HSSFCell cell3 = row.createCell(3);// 第4个单元格
			cell3.setCellValue("2|财政票据");

			HSSFCell cell4 = row.createCell(4);// 第5个单元格
			cell4.setCellValue("222");
			HSSFCell cell5 = row.createCell(5);// 第6个单元格
			cell5.setCellValue("222");
			count++;// 因为count++代表下行开始，不加数据就覆盖了
		}
		HSSFRow rowTotal = sheet.createRow(10);
		HSSFCellStyle hstyle = wb.createCellStyle();
		hstyle.setFillForegroundColor(IndexedColors.YELLOW1.index);
		hstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		HSSFCell cell0 = rowTotal.createCell(0);// 第1个单元格
		cell0.setCellStyle(hstyle);
		cell0.setCellValue("合计");

		HSSFCell cell5 = rowTotal.createCell(5);// 第6个单元格
		cell5.setCellStyle(hstyle);
		cell5.setCellValue("100");

		String fileName = "barter应税服务减除项目清单";
		response.setContentType("application/octet-stream;charset=UTF-8");
		response.setHeader("Content-Type", "application/vnd.ms-excel");
		response.setHeader("Content-disposition",
				"attachment; filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
		OutputStream out = response.getOutputStream();
		wb.write(out);
		// 关流
		out.flush();
		out.close();

	}

	/**
	 ** 
	 * @Description:文化事业，扣除项目清单导入.完整做法。包括加颜色。主要参考前端参数的获取方式、编码转换、结果响应
	 * @param: @param data
	 * @param: @param request
	 * @param: @param response
	 * @param: @return
	 * @return: ResultDto<?>
	 */
//	@RequestMapping(value = "/whsyjsfExcelExport", method = RequestMethod.POST)
//	public ResultDto<?> whsyjsfExcelExport(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e2) {
//			LOG.debug("编码转换异常");
//			throw new SbzxBizException("编码转换异常");
//		}
//		// 不在whsyjsfExcelExport（）形参中直接声明data是因为，开发环境测试环境都没乱码但是生产环境出现了乱码问题
//		String parameterData = request.getParameter("data");
//		if (StringUtils.isBlank(parameterData)) {
//			return ResultDto.valueOfError("不存在数据，不支持导出");
//		}
//		System.out.println(parameterData.toString());
//		List<YsfwxmjcqdGridlb> list = JSONArray.parseArray(parameterData, YsfwxmjcqdGridlb.class);// 将json串解析成list
//
//		FileInputStream inStream = null;
//		HSSFWorkbook wb = null;
//		// 读取excel模板
//		String fileName = "whsyjsfkcxmqd";
//		// 相对路径
//		String filePath = "SbzxApp/config/PDFTemplate/" + fileName + ".xls";
//		// 绝对路径
//		filePath = AppEnv.getAppFilePath() + filePath;
//		try {
//			inStream = new FileInputStream(new File(filePath));
//			wb = new HSSFWorkbook(inStream);
//		} catch (Exception e) {
//			LOG.debug("获取应税服务减除项目清单Excel模板文件失败");
//			throw new SbzxBizException("获取应税服务减除项目清单Excel文件失败");
//		}
//		int count = 4;// 代表excel第5行
//		double jeTotal = 0.0;// 合计金额
//		// 读取了模板内sheet页名称得到sheet页：
//		HSSFSheet sheet = wb.getSheet("应税服务减除项目清单");//
//		for (int i = 0; i < list.size(); i++) {// 从第五行开始写数据
//			HSSFRow row = sheet.createRow(count);// 第5行開始写数据，下次遍歷開始count++
//
//			YsfwxmjcqdGridlb ysfwxmjcqdGridlb = list.get(i);
//			String kpfdwmc = ysfwxmjcqdGridlb.getKpfdwmc();
//			String pzzlDm1 = ysfwxmjcqdGridlb.getPzzlDm1();
//			String fwxmmc = ysfwxmjcqdGridlb.getFwxmmc();
//			// 编码问题,应该是前端的请求头没设置utf-8,让前端改
////			try {
////				//可以统一转编码，直接转字符产data就可以。
////				pzzlDm1 = new String(pzzlDm1.getBytes("ISO-8859-1"), "utf-8");
////				kpfdwmc = new String(kpfdwmc.getBytes("ISO-8859-1"), "utf-8");
////				fwxmmc = new String(fwxmmc.getBytes("ISO-8859-1"), "utf-8");
////			} catch (UnsupportedEncodingException e) {
////				LOG.debug("编码转换异常");
////				throw new SbzxBizException("编码转换异常");
////			}
//			HSSFCell cell0 = row.createCell(0);// 第1个单元格，开票方纳税人识别号
//			cell0.setCellValue(ysfwxmjcqdGridlb.getKpfnsrsbh());
//
//			HSSFCell cell1 = row.createCell(1);// 第2个单元格，开票方单位名称
//			cell1.setCellValue(kpfdwmc);
//
//			HSSFCell cell2 = row.createCell(2);// 第3个单元格，服务项目名称
//			cell2.setCellValue(fwxmmc);
//
//			HSSFCell cell3 = row.createCell(3);// 第4个单元格。凭证种类代码
//			cell3.setCellValue(pzzlDm1);
//
//			HSSFCell cell4 = row.createCell(4);// 第5个单元格，凭证号码
//			cell4.setCellValue(ysfwxmjcqdGridlb.getPzhm2());
//
//			HSSFCell cell5 = row.createCell(5);// 第6个单元格。金额
//			double je = ysfwxmjcqdGridlb.getJe();
//			cell5.setCellValue(je);
//			jeTotal += je;
//			count++;// 因为count++代表下行开始，不加数据就覆盖了
//		}
//		// 添加带颜色得合计行
//		HSSFRow rowTotal = sheet.createRow(count);
//		HSSFCellStyle hstyle = wb.createCellStyle();
//		hstyle.setFillForegroundColor(HSSFColor.YELLOW.index);
//		hstyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//		hstyle.setFillBackgroundColor(HSSFColor.YELLOW.index);
//
//		HSSFCell cellTotal0 = rowTotal.createCell(0);
//		cellTotal0.setCellStyle(hstyle);
//		cellTotal0.setCellValue("合计");
//
//		HSSFCell cellTotal1 = rowTotal.createCell(1);
//		cellTotal1.setCellStyle(hstyle);
//		cellTotal1.setCellValue("--");
//
//		HSSFCell cellTotal2 = rowTotal.createCell(2);
//		cellTotal2.setCellStyle(hstyle);
//		cellTotal2.setCellValue("--");
//
//		HSSFCell cellTotal3 = rowTotal.createCell(3);
//		cellTotal3.setCellStyle(hstyle);
//		cellTotal3.setCellValue("--");
//
//		HSSFCell cellTotal4 = rowTotal.createCell(4);
//		cellTotal4.setCellStyle(hstyle);
//		cellTotal4.setCellValue("--");
//
//		HSSFCell cellTotal5 = rowTotal.createCell(5);
//		cellTotal5.setCellStyle(hstyle);
//		cellTotal5.setCellValue(jeTotal);
//
//		// 设置响应头
//		response.setContentType("application/octet-stream;charset=UTF-8");
//		response.setHeader("Content-Type", "application/vnd.ms-excel");
//		try {
//			response.setHeader("Content-disposition",
//					"attachment; filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
//		} catch (UnsupportedEncodingException e1) {
//			LOG.debug("应税服务减除项目清单导出：编码转换异常");
//			throw new SbzxBizException("应税服务减除项目清单导出：编码转换异常");
//		}
//		OutputStream out = null;
//		try {
//			out = response.getOutputStream();
//			wb.write(out);
//			// 关流
//			out.flush();
//			out.close();
//		} catch (IOException e) {
//			LOG.debug("应税服务减除项目清单导出：获取输出流失败");
//			throw new SbzxBizException("应税服务减除项目清单导出：获取输出流失败");
//		} finally {
//			try {
//				// 关闭资源
//				out.close();
//				inStream.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return ResultDto.valueOfSuccess();
//	}


}
