package bartermall;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.junit.Test;

import com.itextpdf.text.Document;

import com.itextpdf.text.DocumentException;

import com.itextpdf.text.pdf.AcroFields;

import com.itextpdf.text.pdf.PdfCopy;

import com.itextpdf.text.pdf.PdfImportedPage;

import com.itextpdf.text.pdf.PdfReader;

import com.itextpdf.text.pdf.PdfStamper;

public class TestPDF {


	/**
	 ** 
	 * @Description:使用word生产pdf，再用abdoe给pdf设置表单域，再把pdf模板后台填充数据生成pdf，响应给前端
	 * @param:
	 * @return: void
	 */
	@Test
	public void pdfToPDf() {

		// 模板路径
		String projectUrl = System.getProperty("user.dir");// 得到项目的路径
		String templatePath = projectUrl + "\\src\\main\\webapp\\templatePDF\\pdfaaa.pdf";
		// 生成的新文件路径
		String newPDFPath = "F:/JavaIO/pdf生成测试.pdf";
		PdfReader reader;
		FileOutputStream out;
		ByteArrayOutputStream bos;
		PdfStamper stamper;
		try {
			out = new FileOutputStream(newPDFPath);// 输出流
			reader = new PdfReader(templatePath);// 读取pdf模板
			bos = new ByteArrayOutputStream();
			stamper = new PdfStamper(reader, bos);
			AcroFields form = stamper.getAcroFields();
			String[] str = { "123456789", "TOP__ONE", "男", "1991-01-01", "130222111133338888", "河北省保定市" };
			int i = 0;
			java.util.Iterator<String> it = form.getFields().keySet().iterator();
			while (it.hasNext()) {
				String name = it.next().toString();
				System.out.println(name);
				form.setField(name, str[i++]);
			}
			stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
			stamper.close();
			Document doc = new Document();
			PdfCopy copy = new PdfCopy(doc, out);
			doc.open();
			PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
			copy.addPage(importPage);
			doc.close();
		} catch (IOException e) {
			System.out.println(1);
		} catch (DocumentException e) {
			System.out.println(2);
		}
	}

	
}

