package bartermall;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import bartermall.common.util.HttpClient;

public class TestWebservice {
	/**
	 **   
	 * @Description:使用http调用别的服务查手机号归属地
	 * @param:       
	 * @return: void      
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@Test
	public void getPhoneLocation() throws Exception {
		 //HttpClient：在java代码中模拟Http请求
		String number="18838204960";
		HttpClient client = new HttpClient("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx"

            + "/getMobileCodeInfo?mobileCode=" + number + "&userID=");
		client.setHttps(true);
		client.post(); // 发送post请求
		// 4.获取结果
		String xmlContent = client.getContent();// 返回的结果
		System.out.println();
	}
	

}
