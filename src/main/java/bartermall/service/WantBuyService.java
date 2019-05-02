package bartermall.service;

import java.util.List;

import bartermall.pojo.WantInfo;
import bartermall.pojo.WantInfoWithUserInfo;

public interface WantBuyService {

	/**
	 **   
	 * @Description:用户想要求购的物品
	 * @param: @param wantInfo      
	 * @return: void      
	 */
	public void WantBuyGoods(WantInfo wantInfo);

	/**
	 **   
	 * @Description:，求购专区用来遍历表wantinfo表显示所有求购商品
	 * @param:       
	 * @return: void      
	 */
	public List<WantInfoWithUserInfo> getWantInfoWithUserInfoList();

}
