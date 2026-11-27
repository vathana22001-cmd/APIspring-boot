package kh.edu.istad.restfulapi.repository;

import kh.edu.istad.restfulapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}