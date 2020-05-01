package edu.miu.cs.cs425.hackathonaja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.hackathonaja.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
