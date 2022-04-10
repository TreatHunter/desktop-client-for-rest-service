package com.treathunter;

import com.treathunter.rest.services.ClothesService;
import com.treathunter.rest.services.WeaponsService;
import com.treathunter.ui.clothes.ClothesPane;
import com.treathunter.ui.weapons.WeaponsPane;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final ClothesService clothesService;
    private final WeaponsService weaponsService;

    public Main(ClothesService clothesService, WeaponsService weaponsService) {
        this.clothesService = clothesService;
        this.weaponsService = weaponsService;
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

        JTabbedPane tabbedPane = new JTabbedPane();

        ClothesPane clothesPane = new ClothesPane(clothesService, frame);
        tabbedPane.addTab("Одежда",clothesPane);

        WeaponsPane weaponsPane = new WeaponsPane(weaponsService,frame);
        tabbedPane.addTab("Оружие",weaponsPane);

        frame.setContentPane(tabbedPane);
        frame.setVisible(true);


    }
}