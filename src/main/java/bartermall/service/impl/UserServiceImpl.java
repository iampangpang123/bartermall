package bartermall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bartermall.mapper.UserMapper;
import bartermall.pojo.User;
import bartermall.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(String id) {

		return userMapper.getUserById(id);
	}

	@Override
	public User getUserByIdPwd(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUserByIdPwd(user);
	}

	@Override
	public List<User> findUserByUsername(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public void updateUserInfo(User user) {
		userMapper.updateUserInfo(user);

	}

	@Override
	public void addPointByReleaseProduct(String id) {
		userMapper.addPointByReleaseProduct(id);

	}

	@Override
	public void updateUserPhoto(User user) {
		userMapper.updateUserPhoto(user);

	}
}
