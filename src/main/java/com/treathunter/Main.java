package com.treathunter;

import com.treathunter.ui.clothes.ClothPane;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class).headless(false).run(args);
    }

    @Override
    public void run(String... args) {
        JFrame frame = new JFrame("Spring Boot Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setResizable(false);
       // JPanel panel = new JPanel(new BorderLayout());
       // JTextField text = new JTextField("Spring Boot can be used with Swing apps");
       // panel.add(text, BorderLayout.CENTER);
        ClothPane clothPane = new ClothPane(frame);
        frame.setContentPane(clothPane);
        frame.setVisible(true);


    }
}