package com.productservices.productservices.Services;

import com.productservices.productservices.dtos.ProductDto;
import com.productservices.productservices.models.Category;
import com.productservices.productservices.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductServicesImpl implements ProductServices{

    private RestTemplateBuilder restTemplateBuilder;

      public FakeStoreProductServicesImpl (RestTemplateBuilder restTemplateBuilder){
		  this.restTemplateBuilder=restTemplateBuilder;
	  }
	@Override
	public List<Product> getAllProducts() {
		  RestTemplate restTemplate=restTemplateBuilder.build();
		 ResponseEntity<ProductDto[]> l= restTemplate.getForEntity(
				  "https://fakestoreapi.com/products",
				  //this below list class will , this class will add the list of products
				  ProductDto[].class

		  );

		List<Product> answer =new ArrayList<>();
		for(ProductDto productDto : l.getBody()){
//			ProductDto productDto=new ProductDto();
			Product product=new Product();
			product.setId(productDto.getId());
			product.setTitle(productDto.getTitle());
			product.setPrice(productDto.getPrice());
			Category category=new Category();
			category.setName(productDto.getCategory());
			product.setImageUrl(productDto.getImage());
			answer.add(product);

		}
		return answer;
	}



	/*
	BELOW CODE
	return a product object with all the details of the fetched products with
	the id of the category will be null but the name if the category shall be correct
	 */
	@Override
	public Product getSingleProduct(Long productId) {
		RestTemplate restTemplate=restTemplateBuilder.build();
		ResponseEntity<ProductDto> response =restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class , productId);
//				getforentity tells which entity to all and provide fakestore api
//				url and over the network what type of data is comming
//				json so but java takes as object that object should
//				have same parameter as fackestore api , and we have such
//				class as productDto which is same as fakestoreApi and pass productI
// and any parameter in the url
		ProductDto productDto=response.getBody();
		Product product=new Product();
		product.setId(productDto.getId());
		product.setTitle(productDto.getTitle());
		product.setPrice(productDto.getPrice());
		Category category=new Category();
		category.setName(productDto.getCategory());
		product.setImageUrl(productDto.getImage());

		return product;

	}

	@Override
	public Product addNewProduct(ProductDto product) {
 RestTemplate restTemplate=restTemplateBuilder.build();
 ResponseEntity<ProductDto>response=restTemplate.postForEntity(
		 "https://fakestoreapi.com/products",
		 product,
		 ProductDto.class
 );
		ProductDto productDto=response.getBody();
		Product product1=new Product();
		product1.setId(productDto.getId());
		product1.setTitle(productDto.getTitle());
		product1.setPrice(productDto.getPrice());
		Category category=new Category();
		category.setName(productDto.getCategory());
		product1.setImageUrl(productDto.getImage());

		return product1;
	}

	@Override
	public String updateProduct(Long productId, Product product) {

		return null;
	}

	@Override
	public boolean deleteProduct(Long productId) {
		return false;
	}
}
