package com.example.demo.web;

import com.example.demo.database.DatabaseImmitator;
import com.example.demo.structures.ExampleRespond;
import com.example.demo.structures.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TestRESTController {
    private final DatabaseImmitator db;
    private final Random random = new Random();
    public TestRESTController(DatabaseImmitator immitator){
        this.db=immitator;
    }

    //Старый тест, скоро уберу
    private static String template = "Hello, user %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/test")
    public ExampleRespond counter(@RequestParam(defaultValue = "World") String name) {
        return new ExampleRespond(counter.incrementAndGet(), template.formatted(name), 200);
    }

    @GetMapping("/base")
    public RedirectView redirectToRandomProduct() {
        long randomId = random.nextInt(1, 5);
        return new RedirectView("/base/" + randomId);
    }

    @GetMapping("/base/{id}")
    public Product getProduct(@PathVariable Long id){
        if (id == null){
            id = random.nextLong(6);
        }
        return db.getProduct(id);
    }
}
