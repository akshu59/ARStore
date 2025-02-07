package com.akshu.springboot2.jpahibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshu.springboot2.jpahibernate.pojo.Product;

public interface SpringJpaRepo extends JpaRepository<Product, Long> {

	public Product findByProductId(String productId);
}
