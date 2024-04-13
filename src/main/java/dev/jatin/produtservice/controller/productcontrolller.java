package dev.jatin.produtservice.controller;

import dev.jatin.produtservice.dtos.RequestBodyProductDto;
import dev.jatin.produtservice.models.Product;
import dev.jatin.produtservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class productcontrolller {


      ProductService productService;
    public productcontrolller(@Qualifier("fakestore") ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody RequestBodyProductDto request){
        return productService.createProduct(request.getTitle(),
                request.getDescription(),
                request.getPrice(),
                request.getCategory(),
                request.getImage());

    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id){
        /*
        1 - > directly make a call fakestore api
        2 - > productService.getProductDetails()
         */
        return productService .getSingleProduct(id);
    }

    @GetMapping("/products")
    public void getAllProducts(){
    }


    public void updateProduct(){

    }

}
