package com.productservices.productservices.Controller;

import com.productservices.productservices.Services.ProductServices;

import com.productservices.productservices.dtos.ProductDto;
import com.productservices.productservices.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
 public ProductServices productServices;
	
    @GetMapping()
    public List<Product> getAllProducts(){
        return productServices.getAllProducts();
    }

     @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){

         MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();
         headers.add(
                 "auth-token", "NoExcessForYou"
         );

         ResponseEntity<Product>response= new ResponseEntity(
                 productServices.getSingleProduct(productId),
                headers,
                HttpStatus.NOT_FOUND
         );
        return  response;



    }
     @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto product){

        Product newProduct=productServices.addNewProduct(product);
        ResponseEntity<Product>response=new ResponseEntity<>(newProduct,HttpStatus.OK);

        return response;
    }

@PutMapping("/{productId}")
    public  String updateProduct(@PathVariable("productId") Long productId){
        return "Updating product";
    }


    @DeleteMapping("/{productId}")

    public  String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting a Product with id"+productId;
    }
}
