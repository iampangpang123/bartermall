package bartermall;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;


public class TestRead {

	@Test
	public void test() throws IOException {
		String projectUrl = System.getProperty("user.dir");// 得到项目的路径
		String filePath = projectUrl + "\\src\\main\\webapp\\b.txt";
		System.out.println(filePath);
		File file = new File(filePath);
		FileInputStream fileInputStream = new FileInputStream(file);
		int b = fileInputStream.read();
		String result = "";
		while (b != -1) {
			// System.out.print((char) b);
			/*
			 * 如果不charb，得到的都是这样的编码数字165 182 165 182 165 180
			 */ result = result + String.valueOf((char) b);
			b = fileInputStream.read();

			System.out.println(result);
			;
		}
		fileInputStream.close();

	}

	@Test
	public void test1() throws IOException {
		String projectUrl = System.getProperty("user.dir");// 得到项目的路径
		String filePath = projectUrl + "\\src\\main\\webapp\\b.txt";
		System.out.println(filePath);
		File file = new File(filePath);
		String str = "";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[512];
			int n;
			while ((n = fis.read(b)) != -1) {
				str = str + new String(b, 0, n);
				b = new byte[512];
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(str);
	}
}
