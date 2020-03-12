package bartermall.pdf;



import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
* Utils - html转换成PDF
*/
public class HtmlToPdf {

   private HtmlToPdf() {}


   private static String getCurrentOperationSystem() {
       String os = System.getProperty("os.name").toLowerCase();
       return os;
   }


   
   /**
    * @param inputFile 你的html 路径
    * @param outFile 生成PDF的路径
    *    实测：这个方法是可以得，但是要严格<a></a>要对称
    * @return 
    */
   public static Boolean HtmlCovertPdf(String inputFile,String outFile){
       FileOutputStream os = null;
       try {
           os = new FileOutputStream(outFile);
           ITextRenderer renderer = new ITextRenderer();

           ITextFontResolver fontResolver = renderer.getFontResolver();
           //解决中文编码
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
   
   public static void main(String[] args){
	   
		String projectUrl = System.getProperty("user.dir");// 得到项目的路径
		String templatePath = projectUrl + "\\src\\main\\webapp\\templatePDF\\htmlToPdf.html";
       File file = new File(templatePath);
		String newPDFPath = "F:/JavaIO/htmToPDF.pdf";
       try{
         //  htmlToPdf(file, newPDFPath);
    	   HtmlCovertPdf(templatePath, newPDFPath);
       }catch (Exception e){
           e.printStackTrace();
       }
   }
   
}

