package bartermall;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.wxpay.sdk.WXPayUtil;

public class TestPay {
	// 公众账号ID
	@Value("appid")
	String appid;
	// 财付通平台的商户账号
	@Value("partner")
	String partner;

	// 财付通平台的商户密钥
	@Value("partnerkey")
	String partnerkey;
	// 回调地址
	@Value("notifyurl")
	String notifyurl;

	@Test
	public void test() {
		
		///ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:weixinpay.xml");
		//System.out.println(partner);
		// 1.参数的封装
		Map<String, String> parmsMap = new HashMap<String, String>();
		parmsMap.put("appid", appid);// 公众账号ID
		parmsMap.put("mch_id", partner);// 商户号
		parmsMap.put("nonce_str", WXPayUtil.generateNonceStr());// 随机字符串
		// parmsMap.put("", );//签名也是必须的，先不给，sdk可以自动给
		parmsMap.put("body", "华为手机Mata20");// 商品描述
		parmsMap.put("out_trade_no", "555555555");// 商户订单号，这个是controller传递过来的
		parmsMap.put("total_fee", "56.02");// 总金额（分）这个是controller传递过来的
		parmsMap.put("spbill_create_ip", "127.0.0.1");// IP
		/*
		 * 异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
		 */
		parmsMap.put("notify_url", "http://test.itcast.cn");// (通知地址) 回调地址(随便写)
		parmsMap.put("trade_type", "NATIVE");// 交易类型

		try {
			// 2.生成要发送请求需要的xml文件，
			String xmlParam = WXPayUtil.generateSignedXml(parmsMap, partnerkey);// 财付通平台的商户密钥
			System.out.println(xmlParam);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
