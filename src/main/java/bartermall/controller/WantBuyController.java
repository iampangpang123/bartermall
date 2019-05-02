package bartermall.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bartermall.pojo.User;
import bartermall.pojo.WantInfo;
import bartermall.pojo.WantInfoWithUserInfo;
import bartermall.service.WantBuyService;

@Controller
public class WantBuyController {

	@Autowired
	public WantBuyService wantBuyService;

	/*
	 * 求购专区，求购专区用来遍历表wantinfo表显示所有求购商品
	 */
	@ResponseBody
	@RequestMapping("wantBuyGoodsArea")
	public List<WantInfoWithUserInfo> wantBuyGoodsArea(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		List<WantInfoWithUserInfo> list = new ArrayList<>();

		list=wantBuyService.getWantInfoWithUserInfoList();
  
		System.out.println(list);
		return list;
		
		/*
		 * Gson gson = new Gson(); String json = gson.toJson(list);
		 * response.getWriter().write(json);
		 */

		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/*
	 * 用户想要求购的物品
	 */
	@RequestMapping("wantBuyGoods")
	public void WantBuyGoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		User session = (User) request.getSession().getAttribute("user");
		String title = request.getParameter("title");// 商品名称
		String desc = request.getParameter("desc");// 描述
		String trade_place = request.getParameter("trade_place");// 交易地点
		String price = request.getParameter("price");// 期望价格
		String userid = session.getId();
		String wid = UUID.randomUUID().toString().replace("-", "");// 补求购商品id
		// 补上发布时间，根据这个排序
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");

		String creattime = sdf.format(new Date());
		WantInfo wantInfo = new WantInfo(wid, userid, title, desc, price, trade_place, creattime);
		wantBuyService.WantBuyGoods(wantInfo);
		response.sendRedirect("index.jsp");

	}

}
