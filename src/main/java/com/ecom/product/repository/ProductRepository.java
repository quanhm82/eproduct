/**
 * 
 */
package com.ecom.product.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecom.product.model.Product;

/**
 * @author quanhoang
 * Rest Repository for Product resource
 */
@RepositoryRestResource(path = "product", itemResourceRel = "product", collectionResourceRel = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> {

}
