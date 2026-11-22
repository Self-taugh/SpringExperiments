package com.example.demo.structures;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
public class Product {
    @NotNull
    private Long id;
    private String name;
    private String description;
    private double price;
    private int count;
}
