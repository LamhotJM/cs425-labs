package edu.miu.cs.cs425.hackathonaja.service;

import org.springframework.data.domain.Page;

import edu.miu.cs.cs425.hackathonaja.model.Product;

import java.util.List;

public interface ProductService {

    public abstract List<Product> getAllProducts();
    public abstract Page<Product> getAllProductsPaged(int pageNo);
    public abstract Product saveProduct(Product product);
    public abstract Product getProductById(Long productId);

}
