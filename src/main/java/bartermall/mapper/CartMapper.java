package bartermall.mapper;

import bartermall.pojo.Product;

public interface CartMapper {
	public Product findProductById(String pid);
}
