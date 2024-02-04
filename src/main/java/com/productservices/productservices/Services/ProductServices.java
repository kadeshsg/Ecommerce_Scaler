package com.productservices.productservices.Services;

import com.productservices.productservices.dtos.ProductDto;
import com.productservices.productservices.models.Product;

import java.util.List;

public interface ProductServices {

	List<Product> getAllProducts();

	Product getSingleProduct(Long productId);

	Product addNewProduct( ProductDto product);

	String updateProduct(Long productId, Product product);

	boolean  deleteProduct(Long productId);

}