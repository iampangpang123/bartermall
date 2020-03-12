package bartermall.pdf;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.net.URL;

import java.net.URLConnection;

import java.io.*;

/**
 * 
 * Filename: JspToHtml.java <br>

 * 
 */

public class DynamicsHtmlToPDF {


	

	/**
	 ** 
	 * @Description:我自己写的独取html文件然后,把###{#name}###附上数据，再生成html文件,再独取html，转成pdf
	 * @param: @throws IOException
	 * @return: void
	 * @throws DocumentException 
	 */
	@Test
	public void htmltohtml() throws IOException, DocumentException {
		// 1.读取html文件
		String projectUrl = System.getProperty("user.dir");// 得到项目的路径
		String templatePath = projectUrl + "\\src\\main\\webapp\\templatePDF\\htmlToPdf2.html";
		System.out.println(templatePath);
		File file = new File(templatePath);
		FileInputStream fileInputStream = new FileInputStream(file);
		int b = fileInputStream.read();
		StringBuilder result = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(templatePath), "UTF-8"));
		String s = null;
		while ((s = br.readLine()) != null) {
			result.append(System.lineSeparator() + s);
		}
		br.close();
		// 2.独取完html后，给指定位置换上对应值
		Map<String, String> map = new HashMap<String, String>();
		map.put("###title###", "这是标11sssaaaaaaaaassssss111题");
		map.put("###author###", "我是作111111者们的身体就像一个城市，每个们的身体就像一个城市，每个");
		map.put("###content###", "我们的身体就像一个城市，每个细胞都是一幢城市中的大楼。大楼正常工作，才能维持身体正常机+\n"
				+ "能aaaaaaaaaaaa。");
		map.put("###html###", "我们得身体就像一个城市");
		String replaceResult = "";
		for (Map.Entry<String, String> entry : map.entrySet()) {
			replaceResult = result.toString().trim().replace(entry.getKey(), entry.getValue());
			result = new StringBuilder(replaceResult);
		}
		System.out.println(replaceResult);
		// 到这里参数替换完毕

		// 3.把处理后得字符串生成临时得html文件
		File outfile = new File("F:/JavaIO/temp.html");
		if (!outfile.exists()) {// 如果文件不存在则创建
			outfile.createNewFile();
		} else {
			outfile.delete();   
		}   
		// 获取该文件的缓冲输出流
		BufferedWriter bufferedWriter = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(outfile), "UTF-8"));
		// 写入信息
		bufferedWriter.write(replaceResult);
		bufferedWriter.flush();// 清空缓冲区
		bufferedWriter.close();// 关闭输出流
		// 4.把临时得temp.html文件转成pdf，并删除temp.html临时文件
		HtmlToPdf.HtmlCovertPdf("F:/JavaIO/temp.html", "F:/JavaIO/temp.pdf");
		if (outfile.exists()) {// 删除临时得temp.html文件
			outfile.delete();
		}

		
	}
	
	
}
