package com.akshu.springboot2.jpahibernate;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshu.springboot2.jpahibernate.pojo.Product;
import com.akshu.springboot2.jpahibernate.repository.SpringJpaRepo;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private SpringJpaRepo springJpaRepo;

	@GetMapping("")
	public ResponseEntity<Map<String, Object>> getAll() {
		List<Product> list = springJpaRepo.findAll();

		return ResponseEntity.ok(Map.of("data", list));
	}

	/*
	 * @GetMapping("/{id}") public Product getOne(@PathVariable Long id) { return
	 * springJpaRepo.findById(id).get(); }
	 */

	@GetMapping("/{productId}")
	public Product getOne(@PathVariable String productId) {
		return springJpaRepo.findByProductId(productId);
	}

	@PostMapping("")
	public void save(@RequestBody Product product) {
		springJpaRepo.save(product);
	}

	@PutMapping("/{productId}")
	public ResponseEntity<Map<String, Object>> updateProduct(@PathVariable String productId,
			@RequestBody Product updatedProduct) {
		Product product = springJpaRepo.findByProductId(productId);
		if (product != null) {
			if (updatedProduct.getPrice() != null) {
				product.setPrice(updatedProduct.getPrice());
			}
			if (updatedProduct.getName() != null) {
				product.setName(updatedProduct.getName());
			}
			if (updatedProduct.getDescription() != null) {
				product.setDescription(updatedProduct.getDescription());
			}
			if (updatedProduct.getProductId() != null) {
				product.setProductId(updatedProduct.getProductId());
			}

			springJpaRepo.save(product);
			return ResponseEntity.ok(Map.of("Respose", "Product Updated Successfully"));
		}
		return ResponseEntity.ok(Map.of("error", "Product Not Found"));
	}

}
