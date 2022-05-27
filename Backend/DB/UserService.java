package com.user.service;
import java.util.List;

import com.user.dto.*;
public interface UserService {
	List<UserDTO> getProducts();
	UserDTO getProduct(Integer productId);
	UserDTO createProduct(UserDTO product);
	UserDTO updateProduct(Integer productId, UserDTO productDTO );
	UserDTO partialupdateProduct(Integer productId, String name );
	void deleteProduct(Integer productId);
	void deleteAll();
	List<UserDTO> searchProducts(String query);

}