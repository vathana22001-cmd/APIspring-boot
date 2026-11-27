package kh.edu.istad.restfulapi.service.impl;

import kh.edu.istad.restfulapi.model.Category;
import kh.edu.istad.restfulapi.repository.CategoryRepository;
import kh.edu.istad.restfulapi.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category not found: " + id));
    }

    @Override
    public void deleteById(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found: " + id);
        }

        categoryRepository.deleteById(id);
    }
}
