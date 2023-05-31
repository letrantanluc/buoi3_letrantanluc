package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.service.BookService;
import com.example.demo.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllCategories(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "category/list";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model){

        model.addAttribute("category",new Category());

        return "category/add";
    }



    @PostMapping("/add")
    public String addCategory (@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
        //Trường hợp có lỗi ràng buộc thì trả lại view add
        if (bindingResult.hasErrors()) {

            model.addAttribute("categories", categoryService.getAllCategories());
            return "category/add";
        }
        categoryService.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            model.addAttribute("category", category);
            return "category/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editCategory(@Valid @ModelAttribute("category") Category updatedCategory, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "category/edit";
        }

        Category categoryToUpdate = categoryService.getCategoryById(updatedCategory.getId());
        if (categoryToUpdate != null) {
            // Thực hiện cập nhật thông tin của đầu sách
            categoryToUpdate.setName(updatedCategory.getName());

            categoryService.updateCategory(categoryToUpdate);
        }

        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id)
    {
        Category category = categoryService.getCategoryById(id);
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
