package bartermall.service;

import java.util.List;

import bartermall.pojo.Product;
import bartermall.pojo.User;

public interface AdminService {
	public List<User> findUserList();

	public List<Product> findProductsList();
}
