package com.treathunter;

import com.treathunter.rest.services.ClothService;
import com.treathunter.ui.clothes.ClothPane;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final ClothService clothService;

    public Main(ClothService clothService) {
        this.clothService = clothService;
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
        ClothPane clothPane = new ClothPane(clothService, frame);
        frame.setContentPane(clothPane);
        frame.setVisible(true);


    }
}