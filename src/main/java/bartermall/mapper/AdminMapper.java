package bartermall.mapper;

import java.util.List;

import bartermall.pojo.Product;
import bartermall.pojo.User;

public interface AdminMapper {

	
	public List<User> findUserList();
	public List<Product> findProductsList();
}
