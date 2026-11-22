package com.example.demo.structures;

import org.springframework.stereotype.Component;

@Component
public class TestDepInjComponent {

    private String container;

    public TestDepInjComponent(){
        this.container = "Test";
    }
    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }
}
