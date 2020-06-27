package com.ecom.product.cmdRunner;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.product.model.Category;
import com.ecom.product.model.Product;
import com.ecom.product.repository.CategoryRepository;
import com.ecom.product.repository.ProductRepository;

/**
 * @author quanhoang
 * Data samples for Dev or Local profile
 */
@Component
@Order(1)
@Profile(value = {"dev", "local"})
public class DataSampleInitRunner implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(DataSampleInitRunner.class);
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		logger.info("Init sample data.....");
		initCategory();
		initProduct();
	}

	@Transactional
	protected void initCategory() {
		Category computerCategory = new Category();
		computerCategory.setCategoryCode("COMP");
		computerCategory.setCategoryName("Computer");
		
		Category foodCategory = new Category();
		foodCategory.setCategoryCode("FNB");
		foodCategory.setCategoryName("Food and Beverage");
		
		categoryRepository.save(computerCategory);
		categoryRepository.save(foodCategory);
	}
	
	@Transactional
	protected void initProduct() {
		Category compCate = categoryRepository.findByCategoryCode("COMP");
		Category fnbCate = categoryRepository.findByCategoryCode("FNB");
		
		Product dell7510 = new Product();
		dell7510.setCategory(compCate);
		dell7510.setDescription("Dell Precision laptop");
		dell7510.setProductName("Dell Precision 7510");
		dell7510.setInStock(200);
		dell7510.setPrice(700);
		
		Product asusRog = new Product();
		asusRog.setCategory(compCate);
		asusRog.setDescription("ASUS ROG Gaming laptop");
		asusRog.setProductName("ASUS ROG STRIX G G531GD-AL025T");
		asusRog.setInStock(2000);
		asusRog.setPrice(850);
		
		Product banana = new Product();
		banana.setCategory(fnbCate);
		banana.setDescription("Imported banana from Brazil");
		banana.setProductName("Brazilian banana");
		banana.setInStock(7000);
		banana.setPrice(5);
		
		Product goldenApple = new Product();
		goldenApple.setCategory(fnbCate);
		goldenApple.setDescription("Imported banana from USA");
		goldenApple.setProductName("Apple - Golden");
		goldenApple.setInStock(100000);
		goldenApple.setPrice(7);
		
		productRepository.saveAll(Arrays.asList(dell7510, asusRog, banana, goldenApple));
		
	}
}
