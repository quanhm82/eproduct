/**
 * 
 */
package com.ecom.product.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.product.model.Product;

/**
 * @author quanhoang
 * Rest Repository for Product resource
 */
@RepositoryRestResource(path = "product", itemResourceRel = "product", collectionResourceRel = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> {

	@RestResource(path = "search/byNameOrDescription")
	List<Product> findByProductNameLikeOrDescriptionLike(@RequestParam String nameLike, @RequestParam String descLike);
	
	@RestResource(path = "search/priceBetween")
	List<Product> findByPriceBetween(@RequestParam double start, @RequestParam double end);
	
	@RestResource(path = "search/stockGreaterThan")
	List<Product> findByInStockGreaterThanEqual( @RequestParam int stock);
}
