package kh.edu.istad.restfulapi.controller;

import kh.edu.istad.restfulapi.model.Category;
import kh.edu.istad.restfulapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return new ResponseEntity<>(
                categoryService.create(category),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}