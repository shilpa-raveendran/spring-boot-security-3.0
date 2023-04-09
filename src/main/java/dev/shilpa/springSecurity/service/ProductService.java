package dev.shilpa.springSecurity.service;

import dev.shilpa.springSecurity.dto.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> productList= null;
    @PostConstruct
    public void loadProductsFromDB(){
        productList= IntStream.rangeClosed(1,100).mapToObj(i -> Product.builder()
                        .productId(i)
                        .name("Product "+i)
                        .qty(new Random().nextInt(10))
                        .price(new Random().nextInt(500)).build()
                ).collect(Collectors.toList());
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductsById(int id){

        return productList.stream()
                .filter(product -> product.getProductId()==id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("product id "+ id+" not found"));

    }
}
