package com.treathunter;

import com.treathunter.rest.services.ClothesService;
import com.treathunter.rest.services.OperationService;
import com.treathunter.rest.services.WeaponsService;
import com.treathunter.ui.menuPanel.MenuPanel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final ClothesService clothesService;
    private final WeaponsService weaponsService;
    private final OperationService operationService;

    public Main(ClothesService clothesService, WeaponsService weaponsService, OperationService operationService) {
        this.clothesService = clothesService;
        this.weaponsService = weaponsService;
        this.operationService = operationService;
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
        frame.setContentPane(new MenuPanel(frame, clothesService, weaponsService,operationService));
        frame.setVisible(true);

    }
}