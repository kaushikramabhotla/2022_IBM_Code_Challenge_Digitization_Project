package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT p FROM Product p WHERE "+
			"p.name LIKE CONCAT('%', :query, '%') "+
			"OR p.description LIKE CONCAT('%', :query, '%')")
	List<User> searchProducts(String query);

}
