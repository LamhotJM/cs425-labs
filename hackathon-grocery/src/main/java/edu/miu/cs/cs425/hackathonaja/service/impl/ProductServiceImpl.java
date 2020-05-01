package edu.miu.cs.cs425.hackathonaja.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.hackathonaja.model.Product;
import edu.miu.cs.cs425.hackathonaja.repository.ProductRepository;
import edu.miu.cs.cs425.hackathonaja.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll(Sort.by("name"));
    }

    @Override
    public Page<Product> getAllProductsPaged(int pageNo) {
        return productRepository.findAll(PageRequest.of(pageNo, 5, Sort.by("name")));
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

}
