package bartermall.mapper;

import java.util.List;

import bartermall.pojo.WantInfo;
import bartermall.pojo.WantInfoWithUserInfo;

public interface WantBuyMapper {
	/**
	 **   
	 * @Description:用户想要求购的物品
	 * @param: @param wantInfo      
	 * @return: void      
	 */
	void WantBuyGoods(WantInfo wantInfo);

	/**
	 **   
	 * @Description:，求购专区用来遍历表wantinfo表显示所有求购商品
	 *                主要显示用户的个人信息和求购商品的个人信息
	 * @param:       
	 * @return: void      
	 */
	List<WantInfoWithUserInfo> getWantInfoWithUserInfoList();

}
