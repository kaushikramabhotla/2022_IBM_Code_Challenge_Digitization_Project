package com.user.service;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository productRepository;

	@Override
	public List<UserDTO> getProducts() {
		List<User>products= productRepository.findAll();
		return products.stream().map(UserDTO::new).collect(Collectors.toList());
		}

	@Override
	public UserDTO getProduct(Integer productId) {
		User product = productRepository.findById(productId).orElseThrow(()-> new UserNotFoundException("Product does not exist with given Id: "));
		return new UserDTO(product);
	}

	@Override
	public UserDTO createProduct(UserDTO productDTO) {
		User product = new User(productDTO);
		return new UserDTO (productRepository.save(product));
	}

	@Override
	@Transactional
	public UserDTO updateProduct(Integer productId, UserDTO productDTO) {
		User product = productRepository.findById(productId).orElseThrow(()-> new UserNotFoundException("Product does not exist with given Id: "));
		product.setName(productDTO.getName());
		product.setRegistration_status(productDTO.getRegistration_status());
		product.setUpdateOn(productDTO.getUpdatedOn());
		
		return new UserDTO(product);
	}

	@Override
	public void deleteProduct(Integer productId) {
		User product = productRepository.findById(productId).orElseThrow(()-> new UserNotFoundException("Product does not exist with given Id: "));
		productRepository.delete(product);
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
		
		
	}
	@Override
	public List<UserDTO> searchProducts(String query)
	{
		List<User>products=productRepository.searchProducts(query);
		return products.stream().map(UserDTO::new).collect(Collectors.toList());
	}
	@Override
	@Transactional
	public UserDTO partialupdateProduct(Integer productId, String name) {
		User product = productRepository.findById(productId).orElseThrow(()-> new UserNotFoundException("Product does not exist with given Id: "));
		product.setName(name);
		//product.setPrice(productDTO.getPrice());
		//product.setUpdatedOn(productDTO.getUpdatedOn());
		
		return new UserDTO(product);
	}

	
	

}