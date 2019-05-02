package bartermall.service;

import java.util.List;

import bartermall.pojo.User;

public interface UserService {
	public List<User> findUserByUsername(User user);

	/**
	 * @Description:根據id查詢用戶，主要用來登錄注冊的時候判斷該id是否存在
	 * @param: @param id
	 * @param: @return
	 * @return: User
	 */
	public User getUserById(String id);

	/**
	 **   
	 * @Description://登錄用的
	 * @param: @param user
	 * @param: @return      
	 * @return: User      
	 */
	public User getUserByIdPwd(User user);

	public void regUser(User user);

	public void updateUserInfo(User user);

	/**
	 **   
	 * @Description:// 用户添加商品的时候，增加用户积分，两分
	 * @param: @param id      
	 * @return: void      
	 */
	public void addPointByReleaseProduct(String id);

	/**
	 **   
	 * @Description:更新用户头像
	 * @param: @param user      
	 * @return: void      
	 */
	public void updateUserPhoto(User user);
}
