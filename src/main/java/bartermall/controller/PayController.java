package bartermall.controller;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bartermall.common.util.IdWorker;
import bartermall.pojo.Result;
import bartermall.service.PayService;

@Controller
@RequestMapping("pay")
public class PayController {
	@Autowired
	private PayService payService;

	/*
	 * 跳转到Pay页面，需要把购物车的订单信息带过去，我们这里就不要带了，跳转到pay页面，水谁便给他些信息让他生辰二维码就行
	 */
	@RequestMapping("jumpPay")
	public void jumpPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 视图解析器配置的是。jsp后缀，我们这个页面是h't'm'l页面，需要使用传统的方式跳转，不走视图解析器

		// request.getRequestDispatcher("/pay/pay.html").forward(request, response);
		response.sendRedirect("pay.html");
	}

	/**
	 ** 
	 * @Description:主要是实现下单，我们带着订单数据访问微信提供的接口，微信会返回一些数据，我们给数据做成二维码返回给用户
	 * @param: @param response
	 * @param: @return
	 * @return: Map
	 */
	@ResponseBody
	@RequestMapping("createNavite")
	public Map createNavite(HttpServletResponse response) {
		// 1.生成订单号
		IdWorker idworker = new IdWorker(); // 订单编号生成器，但是我们没有这个类，自己谁便写了一个编号做测试
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		return payService.createNative(idworker.nextId() + "", "1");// 单位是分，所以是一分钱

	}

	/**
	 ** 
	 * @Description:查询订单支付状态
	 * @param: @param request
	 * @param: @return
	 * @return: Map
	 */
	@ResponseBody
	@RequestMapping("queryOrderStatus")
	public Result queryOrderStatus(HttpServletRequest request) {
		String out_trade_no = request.getParameter("out_trade_no");
//下面代码逻辑有问题************
		Result result = new Result(false, "支付失败");
		int count = 0;
//		while (true) {
//			// 调用查询接口，存在一个问题，就是用户不扫码，直接关闭页面，我们后端会不停的查询这个订单，导致死循环，需要一个计数器进行关闭
//			Map<String, String> map = payService.queryOrderStatus(out_trade_no);
//			map = null;
//			if (map == null) {// 出错
//				result = new Result(false, "支付出错");
//				break;
//			}
//			if (map.get("trade_state").equals("SUCCESS")) {// 如果成功
//				result = new Result(true, "支付成功");
//				break;
//			}
//			try {
//				Thread.sleep(3000);// 间隔三秒,等待订单让微信处理
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		count++;
//		if (count > 100) {
//			result = new Result(false, "支付超时");
//			break;
//		}
//		}

		return result;
	}

}
