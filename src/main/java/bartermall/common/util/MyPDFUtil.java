package bartermall.common.util;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.BaseFont;

public class MyPDFUtil {

	private static final Logger LOG = LoggerFactory.getLogger(MyPDFUtil.class);
	

	
	

	/**
	 **   
	 * @Description:生成pdf，保存在本地
	 * @param: @param tempPath    临时文件路径
	 * @param: @param outPdfPah   输入文件得路径
	 * @param: @param result       
	 * @return: void      
	 */
	public static void CoverHtmlToPdfWithNavicat(String tempPath, String outPdfPah, String result) {
		if (result.equals("")) {
			LOG.debug("html内容为空");
			return;
		}
		// 3.把处理后得字符串生成临时得html文件
		File outfile = new File(tempPath);
		if (outfile.exists()) {// 如果文件不存在则创建
			try {
				outfile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			outfile.delete();
		}
		// 获取该文件的缓冲输出流
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 写入信息
		try {
			bufferedWriter.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.flush();// 清空缓冲区
				bufferedWriter.close();// 关闭输出流
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 4.把临时得temp.html文件转成pdf，并删除temp.html临时文件
		MyPDFUtil.HtmlCovertPdf(tempPath, outPdfPah);
		if (outfile.exists()) {// 删除临时得temp.html文件
			outfile.delete();
		}

	}

	/**
	 ** 
	 * @Description:把html里面得表达式替换成对应得值
	 * @param: templatePath html模板路径
	 * @param: param 是替换html里面表达式得参数
	 * @return:
	 */
	public static String getStringFromHtml(String templatePath, Map<String, String> param) {
		StringBuilder result = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(templatePath), "UTF-8"));
			String s = null;
			while ((s = br.readLine()) != null) {
				result.append(System.lineSeparator() + s);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String replaceResult = "";
		for (Map.Entry<String, String> entry : param.entrySet()) {
			replaceResult = result.toString().trim().replace(entry.getKey(), entry.getValue());
			result = new StringBuilder(replaceResult);
		}

		return replaceResult;

	}

	/**
	 * @param inputFile 你的html 路径
	 * @param outFile   生成PDF的路径 实测：这个方法是可以得，但是要严格<a></a>要对称
	 * @return
	 */
	public static Boolean HtmlCovertPdf(String inputFile, String outFile) {
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(outFile);
			ITextRenderer renderer = new ITextRenderer();

			ITextFontResolver fontResolver = renderer.getFontResolver();
			// 解决中文编码
			if ("linux".equals(getCurrentOperationSystem())) {
				fontResolver.addFont("/usr/share/fonts/chiness/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			} else {
				fontResolver.addFont("c:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			}
			String url = new File(inputFile).toURI().toURL().toString();
			renderer.setDocument(url);
			renderer.layout();
			renderer.createPDF(os);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				os.close();
				System.out.println("aa");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getCurrentOperationSystem() {
		String os = System.getProperty("os.name").toLowerCase();
		return os;
	}

}
