
package kh.edu.istad.restfulapi.service;

import kh.edu.istad.restfulapi.model.Category;
import java.util.List;

public interface CategoryService {

    Category create(Category category);

    List<Category> getAll();

    Category getById(Integer id);

    void deleteById(Integer id);
}
