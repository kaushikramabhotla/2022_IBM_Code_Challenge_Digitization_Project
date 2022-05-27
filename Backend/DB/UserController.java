package com.user.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserDTO;
import com.user.service.UserService;

@RestController
@RequestMapping("/products")
public class UserController {

	@Autowired
	private UserService productService;
	
	@GetMapping("/getall")
	public List<UserDTO> products(){
		return productService.getProducts();
	}
	
	@GetMapping("/search")
	public List<UserDTO> searchProduct(@RequestParam("query")String query){
		return productService.searchProducts(query);
	}
	
	
	@GetMapping("/get/{productId}")
	public UserDTO proudctById(@PathVariable Integer productId){
		return productService.getProduct(productId);
	}
	
	@PostMapping("/save")
	public UserDTO save(@Valid @RequestBody UserDTO prod) {
		return productService.createProduct(prod);
	}
	
	
	
	@Transactional
	@PutMapping("/update/{productId}")
	public UserDTO update(@PathVariable Integer productId, @RequestBody UserDTO prod) {
		return productService.updateProduct(productId, prod);
	}
	@PatchMapping("/partialUpdate/{productId}/{name}")
	public ResponseEntity<UserDTO> partialUpdate(@PathVariable Integer productId, @PathVariable String name) {
		return new ResponseEntity<UserDTO>(productService.partialupdateProduct(productId, name),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{productId}")
	public String delete(@PathVariable Integer productId) {
		productService.deleteProduct(productId);
		return "Product with ID " + productId + " was deleted successfully";
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		productService.deleteAll();
		return "All products deleted successfully";
	}
}
