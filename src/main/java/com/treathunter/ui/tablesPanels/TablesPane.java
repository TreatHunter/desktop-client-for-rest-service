package com.treathunter.ui.tablesPanels;

import com.treathunter.rest.services.ClothesService;
import com.treathunter.rest.services.WeaponsService;
import com.treathunter.ui.menuPanel.MenuPanel;
import com.treathunter.ui.tablesPanels.clothes.ClothesPane;
import com.treathunter.ui.tablesPanels.weapons.WeaponsPane;

import javax.swing.*;

public class TablesPane extends JTabbedPane {
    public TablesPane (JFrame frame, ClothesService clothesService, WeaponsService weaponsService, MenuPanel menuPanel) {
        ClothesPane clothesPane = new ClothesPane(clothesService, frame, menuPanel);
        this.addTab("Одежда",clothesPane);

        WeaponsPane weaponsPane = new WeaponsPane(weaponsService,frame, menuPanel);
        this.addTab("Оружие",weaponsPane);
    }
}
