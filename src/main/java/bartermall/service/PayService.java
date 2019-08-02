package bartermall.service;

import java.util.Map;

public interface PayService {
	/**
	 * 1.发送订单数据给微信，生成微信支付二维码，返回给用户
	 * 
	 * @param out_trade_no 订单号
	 * @param total_fee    金额(分)
	 * @return
	 */
	public Map createNative(String out_trade_no, String total_fee);// 创建本地请求（因为我们采用的是微信的第二种支付模式，也就是本地支付模式）
	/**
	 **   
	 * @Description:2.查询订单的支付状态
	 * @param: @param out_trade_no  订单号
	 * @param: @return      
	 * @return: Map      
	 */
	public Map queryOrderStatus(String out_trade_no);

}
