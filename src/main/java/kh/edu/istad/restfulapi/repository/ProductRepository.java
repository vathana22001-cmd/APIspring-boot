package kh.edu.istad.restfulapi.repository;


import kh.edu.istad.restfulapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}