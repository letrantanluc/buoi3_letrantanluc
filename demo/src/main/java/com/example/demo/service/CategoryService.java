package com.example.demo.service;


import com.example.demo.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Category;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> getAllCategories () {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void addCategory (Category category) {
        categoryRepository.save(category);
    }


    public void deleteCategory (Long id) {
        categoryRepository.deleteById(id);
    }

    public void updateCategory (Category category) {
        categoryRepository.save(category);
    }
}