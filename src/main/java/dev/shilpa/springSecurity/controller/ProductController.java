package dev.shilpa.springSecurity.controller;

import dev.shilpa.springSecurity.dto.Product;
import dev.shilpa.springSecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/welcome")
    public String welcome(){
        return "This is the welcome page";
    }

    @GetMapping("/allProducts")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/productsById/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Product getProductsById(@PathVariable int id){
        return service.getProductsById(id);
    }
}
