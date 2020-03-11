package bartermall.common.util.pdf;
 
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
 
public class Itext5HtmlToPDF {
 
	public static void main(String[] args) {
		new Itext5HtmlToPDF().createPdf();
		System.out.println("aaaaaaaaaaaa");
	}
	
	public void createPdf() {
		try {
			BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
			Font font = new Font(bfChinese, 12, Font.NORMAL);
			
			Document document = new Document(PageSize.A4, 10, 10, 10, 10);
			PdfWriter mPdfWriter = PdfWriter.getInstance(document, new FileOutputStream("F:/JavaIO/pdf生成测试.pdf"));
			document.open();
			
			document.add(new Paragraph("创建pdf文件.支持中文......", font));
			
			String s = getHtml();
			ByteArrayInputStream bin = new ByteArrayInputStream(s.getBytes());
			//XMLWorkerHelper.getInstance().parseXHtml(mPdfWriter, document, bin, Charset.forName("UTF-8"), new ChinaFontProvide());
			document.close();
			mPdfWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public static String getHtml() {
		
		StringBuffer html = new StringBuffer();
		html.append("<div style='color:green;font-size:20px;'>你好世界！hello world !</div>");
		html.append("<span style='color:red'>what are you 弄啥咧!</span>");
		html.append("<h1>标题</h1>");
		html.append("<table>");
		html.append("<tr>");
		html.append("<th>序号</th>");
		html.append("<th>用户名</th>");
		html.append("<th>性别</th>");
		html.append("</tr>");
		html.append("<tr>");
		html.append("<td>1</td>");
		html.append("<td>fengxing</td>");
		html.append("<td>男</td>");
		html.append("</tr>");
		html.append("<tr>");
		html.append("<td>2</td>");
		html.append("<td>admin</td>");
		html.append("<td>女</td>");
		
		html.append("</tr>");
		html.append("</table>");
		
		html.append("<textarea>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/>1<br/></textarea>");
		return html.toString();
	}
 
	/**
	 * 
	 * 提供中文
	 * 
	 */
	public static final class ChinaFontProvide implements FontProvider {
 
		@Override
		public Font getFont(String arg0, String arg1, boolean arg2, float arg3,
				int arg4, BaseColor arg5) {
			BaseFont bfChinese = null;
			try {
				bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
						BaseFont.NOT_EMBEDDED);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
			return FontChinese;
		}
 
		@Override
		public boolean isRegistered(String arg0) {
			return false;
		}
	}
}
