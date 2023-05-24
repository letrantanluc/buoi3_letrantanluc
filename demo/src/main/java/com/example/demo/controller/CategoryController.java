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

//    @GetMapping("/add")
//    public String addCategoryForm(Model model){
//
//        model.addAttribute("category",new Category());
//
//        return "category/add";
//    }

//    @PostMapping("/add")
//    public String addBook(@ModelAttribute("book") Book book){
//        bookService.addBook(book);
//        return "redirect:/books";
//    }

//    @PostMapping("/add")
//    public String addBook (@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
//        //Trường hợp có lỗi ràng buộc thì trả lại view add
//        if (bindingResult.hasErrors()) {
//
//            model.addAttribute("categories", categoryService.getAllCategories());
//            return "book/add";
//        }
//        bookService.addBook(book);
//        return "redirect:/books";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editBook(@PathVariable("id") Long id, Model model) {
//        Book book = bookService.getBookById(id);
//        if (book != null) {
//            model.addAttribute("book", book);
//            model.addAttribute("categories", categoryService.getAllCategories());
//            return "book/edit";
//        } else {
//            return "not-found";
//        }
//    }
//
//    @PostMapping("/edit")
//    public String editBook(@Valid @ModelAttribute("book") Book updatedBook, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("categories", categoryService.getAllCategories());
//            return "book/edit";
//        }
//
//        Book bookToUpdate = bookService.getBookById(updatedBook.getId());
//        if (bookToUpdate != null) {
//            // Thực hiện cập nhật thông tin của đầu sách
//            bookToUpdate.setTitle(updatedBook.getTitle());
//            bookToUpdate.setAuthor(updatedBook.getAuthor());
//            bookToUpdate.setPrice(updatedBook.getPrice());
//            bookToUpdate.setCategory(updatedBook.getCategory());
//
//            bookService.updateBook(bookToUpdate);
//        }
//
//        return "redirect:/books";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteBook(@PathVariable("id") Long id)
//    {
//        Book book = bookService.getBookById(id);
//        bookService.deleteBook(id);
//        return "redirect:/books";
//    }
}
