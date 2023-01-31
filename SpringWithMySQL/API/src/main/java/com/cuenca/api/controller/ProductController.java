package com.cuenca.api.controller;

import com.cuenca.api.modelo.Product;
import com.cuenca.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @GetMapping("/product")
    public List<Product> productList(){
        return productService.productList();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        try{
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/product")
    public void newProduct (@RequestBody Product product){
        productService.saveProduct(product);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable Integer id){
        try{
            Product actualProduct = productService.getProductById(id);
            actualProduct.setName(product.getName());
            actualProduct.setPrice(product.getPrice());
            productService.saveProduct(actualProduct);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        try{
            productService.deleteProduct(id);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
