package bartermall.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.wxpay.sdk.WXPayUtil;

import bartermall.common.util.HttpClient;
import bartermall.service.PayService;

@Service
public class PayServiceImpl implements PayService {

	// 公众账号ID

	@Value("${appid}")
	String appid;
	// 财付通平台的商户账号
	@Value("${partner}")
	String partner;

	// 财付通平台的商户密钥
	@Value("${partnerkey}")
	String partnerkey;

	@Override
	public Map createNative(String out_trade_no, String total_fee) {
		// 1.参数的封装
		Map<String, String> parmsMap = new HashMap<String, String>();
		parmsMap.put("appid", appid);// 公众账号ID
		parmsMap.put("mch_id", partner);// 商户号
		parmsMap.put("nonce_str", WXPayUtil.generateNonceStr());// 随机字符串
		// parmsMap.put("", );//签名sign也是必须的，先不给，sdk可以自动给
		parmsMap.put("body", "Mata20");// 商品描述
		parmsMap.put("out_trade_no", out_trade_no);// 商户订单号，这个是controller传递过来的
		parmsMap.put("total_fee", total_fee);// 总金额（分）这个是controller传递过来的
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
			// 3.发送请求
			HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");// 微信接口连接
			client.setHttps(true);// 代表着合适hhtp请求
			client.setXmlParam(xmlParam);
			client.post(); // 发送post请求
			// 4.获取结果
			String xmlContent = client.getContent();// 返回的结果
			Map<String, String> resultMap = WXPayUtil.xmlToMap(xmlContent);
			System.out.println(resultMap.toString());
			resultMap.put("code_url", resultMap.get("code_url"));// 支付地址
			resultMap.put("total_fee", total_fee);// 总金额
			resultMap.put("out_trade_no", out_trade_no);// 订单号
			return resultMap;

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Map queryOrderStatus(String out_trade_no) {
		Map param=new HashMap();
		param.put("appid", appid);//公众账号ID
		param.put("mch_id", partner);//商户号
		param.put("out_trade_no", out_trade_no);//订单号
		param.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
		String url="https://api.mch.weixin.qq.com/pay/orderquery";		
		try {
			String xmlParam = WXPayUtil.generateSignedXml(param, partnerkey);	
			HttpClient client=new HttpClient(url);
			client.setHttps(true);
			client.setXmlParam(xmlParam);
			client.post();
			String result = client.getContent();			
			Map<String, String> map = WXPayUtil.xmlToMap(result);
			System.out.println(map);
			return map;			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

	

}
