package com.example.demo.database;

import com.example.demo.structures.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DatabaseImmitator {
    private final List<Product> database = Collections.synchronizedList(new ArrayList<Product>());

    public DatabaseImmitator(){
        database.add(new Product(1L, "Мышь", "Мышь компьютерная", 899.99, 5));
        database.add(new Product(2L, "Камера", "Камера Logitech (не реклама)", 1999.99, 8));
        database.add(new Product(3L, "Коврик настольный", "Коврик настольный для компьютерной мыши", 199.98, 3));
        database.add(new Product(4L, "Микрофон", "Микрофон проводной Maono", 1499.69, 1));
    }

    public Product getProduct(long id){
        for (Product product : database){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public Product getProduct(String name){
        for (Product product : database){
            if (product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) throws IllegalArgumentException{
        if (product == null) throw new IllegalArgumentException("Недопустимо создание товара пустышки");
        if (getProduct(product.getId()) != null) throw new IllegalArgumentException("Товар с таким айди уже есть");
        if (product.getCount() < 0 || product.getPrice() < 0) throw new IllegalArgumentException("Недопустимые аргументы");
        database.add(product);
    }

    public boolean removeProduct(Product product){
        Product product1 = getProduct(product.getId());
        if (product1 != null){
            database.remove(product1);
            return true;
        }
        return false;
    }

    // Не хочу писать нормальную функцию замены, обойдусь вот этим. Производительность сейчас не важна
    public void changeProduct(Product product){
        removeProduct(product);
        addProduct(product);
    }
}
