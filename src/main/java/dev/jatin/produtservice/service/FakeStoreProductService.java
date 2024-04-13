package dev.jatin.produtservice.service;


import dev.jatin.produtservice.dtos.FakeStoreProductdta;
import dev.jatin.produtservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakestore")
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductdta fakeStoreProductResponse = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductdta.class);
        /*
        make a call to external fakestore
         */
        return fakeStoreProductResponse.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String category,
                                 String image) {
        FakeStoreProductdta fakeStoreProductdto = new FakeStoreProductdta();
        fakeStoreProductdto.setTitle(title);
        fakeStoreProductdto.setDescription(description);
        fakeStoreProductdto.setPrice(price);
        fakeStoreProductdto.setCategory(category);
        fakeStoreProductdto.setImage(image);
        FakeStoreProductdta fakeStoreProductdto1 = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductdto,
                FakeStoreProductdta.class);

        return fakeStoreProductdto1.toProduct();

    }
}
