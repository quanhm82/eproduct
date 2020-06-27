/**
 * 
 */
package com.ecom.product.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ecom.product.model.Category;

/**
 * @author quanhoang
 * Rest Repository for Category resource
 */
@RepositoryRestResource(path = "category", itemResourceRel = "category", collectionResourceRel = "categories")
public interface CategoryRepository extends PagingAndSortingRepository<Category, UUID> {
	
	@RestResource(path = "byCode")
	Category findByCategoryCode(String categoryCode);
}
