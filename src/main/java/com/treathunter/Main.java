package com.treathunter;

import com.treathunter.rest.services.ClothesService;
import com.treathunter.ui.clothes.ClothesPane;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final ClothesService clothesService;

    public Main(ClothesService clothesService) {
        this.clothesService = clothesService;
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class).headless(false).run(args);
    }

    @Override
    public void run(String... args) {
        JFrame frame = new JFrame("Spring Boot Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setResizable(false);
        ClothesPane clothesPane = new ClothesPane(clothesService, frame);
        frame.setContentPane(clothesPane);
        frame.setVisible(true);


    }
}