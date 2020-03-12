package bartermall.pdf;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

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
 * Ttitle: jsp转换成html<br>
 * 
 * De.ion: 把动态网页转换成静态网页<br>
 * 
 * Copyright: Copyright (c) 2002-2008 BocSoft,Inc.All Rights Reserved. <br>
 * 
 * Company: BocSoft<br>
 * 
 * Author: <a href="mailto:sgicer@163.com">阿汐</a> <br>
 * 
 * Date: 2006-6-19 <br>
 * 
 * Time: 16:41:09 <br>
 * 
 * Version: 2.0.0 <br>
 * 
 */

public class DynamicsHtmlToPDF {

	private static String title = "标题测试";

	private static String context = "标题测试";

	private static String editer = "标题测试";

	/**
	 * 
	 * 根据本地模板生成静态页面
	 * 
	 * @param JspFile  jsp路经
	 * 
	 * @param HtmlFile html路经
	 * 
	 * @return
	 * 
	 */

	public static boolean JspToHtmlFile(String filePath, String HtmlFile) {

		String str = "";

		long beginDate = (new Date()).getTime();

		try {

			String tempStr = "";

			FileInputStream is = new FileInputStream(filePath);// 读取模块文件

			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			while ((tempStr = br.readLine()) != null)

				str = str + tempStr;

			is.close();

		} catch (IOException e) {

			e.printStackTrace();

			return false;

		}

		try {

			str = str.replaceAll("###title###", title);

			str = str.replaceAll("###content###", context);

			str = str.replaceAll("###author###", editer);// 替换掉模块中相应的地方

			File f = new File(HtmlFile);

			BufferedWriter o = new BufferedWriter(new FileWriter(f));

			o.write(str);

			o.close();

			System.out.println("共用时：" + ((new Date()).getTime() - beginDate) + "ms");

		} catch (IOException e) {

			e.printStackTrace();

			return false;

		}

		return true;

	}

	/**
	 * 
	 * 根据url生成静态页面
	 *
	 * 
	 * 
	 * @param u    动态文件路经 如：http://www.163.com/x.jsp
	 * 
	 * 
	 * 
	 * @param path 文件存放路经如：x:\\abc\bbb.html
	 * 
	 * @return
	 * 
	 */

	public static boolean JspToHtmlByURL(String u, String path) {

		// 从utl中读取html存为str

		String str = "";

		try {

			URL url = new URL(u);

			URLConnection uc = url.openConnection();

			InputStream is = uc.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			while (br.ready()) {

				str += br.readLine() + "\n";

			}

			is.close();

			// 写入文件

			File f = new File(path);

			BufferedWriter o = new BufferedWriter(new FileWriter(f));

			o.write(str);

			o.close();

			str = "";

			return true;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	/**
	 * 
	 * 根据url生成静态页面
	 * 
	 * @param url 动态文件路经 如：http://www.163.com/x.jsp
	 */
	public static StringBuffer getHtmlTextByURL(String url) {

		// 从utl中读取html存为str

		StringBuffer sb = new StringBuffer();
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			InputStream is = uc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while (br.ready()) {
				sb.append(br.readLine() + "\n");
			}
			is.close();
			return sb;
		} catch (Exception e) {
			e.printStackTrace();
			return sb;

		}

	}

	/**
	 * 
	 * 测试main 函数
	 * 
	 * @param arg
	 */
	public static void main(String[] arg) {

		long begin = System.currentTimeMillis();
		// 循环生成10个html文件
		for (int k = 0; k < 10; k++) {

			String projectUrl = System.getProperty("user.dir");// 得到项目的路径
			String templatePath = projectUrl + "\\src\\main\\webapp\\templatePDF\\htmlToPdf2.html";

			String newPDFPath = "F:/JavaIO/DynamicsHtmlToPDF.pdf";
			JspToHtmlFile(templatePath, newPDFPath);
		}
		System.out.println("用时:" + (System.currentTimeMillis() - begin) + "ms");

	}

	/**
	 ** 
	 * @Description:我自己写的独取html文件然后,把###{#name}###附上数据，再生成html文件,再独取html，转成pdf
	 * @param: @throws IOException
	 * @return: void
	 */
	@Test
	public void htmltohtml() throws IOException {
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
		System.out.println(result);
		// 2.独取完html后，给指定位置换上对应值
		Map<String, String> map = new HashMap<String, String>();
		map.put("###title###", "这是标11sssaaaaaaaaassssss111题");
		map.put("###author###", "我是作111111者们的身体就像一个城市，每个们的身体就像一个城市，每个");
		map.put("###content###", "我们的身体就像一个城市，每个细胞都是一幢城市中的大楼。大楼正常工作，才能维持身体正常机能aaaaaaaaaaaa。");
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
