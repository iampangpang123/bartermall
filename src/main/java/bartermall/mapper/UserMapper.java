package bartermall.mapper;

import java.util.List;

import bartermall.pojo.User;

public interface UserMapper {
	public List<User> findUserByUsername(User user);

	
	public User getUserById(String id);//登录的ajax方法经常调用
	public User getUserByIdPwd(User user);//登陆密码验证
	public void addUser(User user);//添加用户
	public void updateUserInfo(User user);//补全用户信息


	public void addPointByReleaseProduct(String pid);//用户发布商品的时候，用来指定商品属于那个用户
	public void updateUserPhoto(User user);//更新用户头像
//	
//	public User getUserByName(String userName) {
//		String sql="SELECT id,name,password,email,area,college,grade,tel,QQ qq,photo ,point,"
//				+ "statephoto,(CASE state WHEN '0' THEN '未认证'	WHEN '1' THEN '待认证'	WHEN '2' THEN '已认证' 	END)AS state"
//				+ " FROM user where name = ?";
//		return query(sql, userName);
//	}
//
//
//	public List<User> getUsers() {
//		String sql = "SELECT id,name,password,email,area,college,grade,tel,QQ qq,photo ,point,"
//				+ "statephoto,(CASE state WHEN '0' THEN '未认证'	WHEN '1' THEN '待认证'	WHEN '2' THEN '已认证' 	END)AS state"
//				+ " FROM user ";
//		return queryList(sql);
//	}
//
//
//	public long getUserSum() {
//		String sql = "SELECT COUNT(id) FROM user ";
//		return getValue(sql);
//	}
//

//	
//	//用户完善个人信息
//
//	public void updateUser(User user) {
//		String sql="UPDATE user set name=?,email=?,area=?,college=?,grade=?,tel=?,QQ=? WHERE id=?";
//		update(sql, user.getName(),user.getEmail(),user.getArea(),user.getCollege(),user.getGrade(),user.getTel(),user.getQq(),user.getId());
//	}
//
//	
//	public void updateUserPassword(String id, String newPassword) {
//		String sql = "UPDATE user set password = ? where id=?";
//		update(sql, newPassword,id);
//	}
//	
//	
//	public void deleteUserById(int id) {
//		String sql="DELETE FROM user where id = ?";
//		update(sql, id);
//	}
//

//	
//	public void addPointByReleaseProduct(String uid){
//		String sql="UPDATE `user` u  SET point = point+5  WHERE u.id =  ?";
//		update(sql, uid);
//	}
//	
//	public void addPointByRefresh(String pid){
//		String sql="UPDATE `user` u ,products p SET point = point+2  WHERE u.id = p.beloneto AND p.pid = ?";
//		update(sql, pid);
//	}
//
//
//	public void addPointBySell(String pid) {
//		String sql="UPDATE `user` u ,products p SET point = point+5  WHERE u.id = p.beloneto AND p.pid = ?";
//		update(sql, pid);
//	}
//
//	
//	public void addUserStatePhoto(User user) {
//		String sql = "UPDATE USER SET statephoto = ?,state = 1 WHERE id = ?";
//		update(sql, user.getStatePhoto(),user.getId());
//	}

}
