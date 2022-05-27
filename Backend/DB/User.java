package com.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.user.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_table")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pId;
	
	@Column(name="product_name")
	private String name;
	
	
	private String registration_status;
	
	@Column(name="description")
	private String description;
	@CreatedDate
	private LocalDateTime createdOn;
	
	@UpdateTimestamp
	private LocalDateTime updateOn;
	
	public User(UserDTO productDTO) {
		this.pId=productDTO.getPId();
		this.name=productDTO.getName();
		this.registration_status =productDTO.getRegistration_status();
		
		this.description=productDTO.getDescription();
		this.createdOn=productDTO.getCreatedOn();
		this.updateOn=productDTO.getUpdatedOn();
	}
	@PrePersist
	public void created_on() {
		createdOn=LocalDateTime.now();
	}
	@PreUpdate
	public void updated_on() {
		updateOn=LocalDateTime.now();
	}
}