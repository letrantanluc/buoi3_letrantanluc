package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;
@Data
@Entity
@Table(name = "category")
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50, nullable = false)
    @NotBlank(message = "Name is required")
    private String name;
    @OneToMany (mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;




}

