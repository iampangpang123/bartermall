package bartermall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bartermall.mapper.AdminMapper;
import bartermall.pojo.Product;
import bartermall.pojo.User;
import bartermall.service.AdminService;
@Service
public class AdminServiceImpl  implements AdminService {
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public List<User> findUserList() {
		return adminMapper.findUserList();
	}

	@Override
	public List<Product> findProductsList() {
		// TODO Auto-generated method stub
		return adminMapper.findProductsList();
	}

}
