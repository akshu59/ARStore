package com.akshu.springboot2.jpahibernate.pojo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue
	private Long id;
	
	@Column
	private String productId;
	
	@Column
	private String name;
	
	@Column
	private String price;
	
	@Column
	private String description;

}
