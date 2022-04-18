package com.treathunter.ui.menuPanel;

import com.treathunter.rest.services.ClothesService;
import com.treathunter.rest.services.WeaponsService;
import com.treathunter.ui.billPanel.BillPane;
import com.treathunter.ui.tablesPanels.TablesPane;

import javax.swing.*;

public class MenuPanel extends JPanel {
    private JFrame appFrame;
    private TablesPane tablesPane;
    private BillPane billPane;
    public MenuPanel (JFrame frame, ClothesService clothesService, WeaponsService weaponsService) {
        appFrame = frame;
        tablesPane = new TablesPane(appFrame, clothesService, weaponsService, this);
        billPane = new BillPane(appFrame,this, clothesService, weaponsService);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JButton tablesButton = new JButton("Работа с товарами");
        tablesButton.addActionListener(e -> setContentPane(tablesPane));
        this.add(tablesButton);

        JButton billButton = new JButton("Cоздание чеков");
        billButton.addActionListener(e -> setContentPane(billPane));
        this.add(billButton);

    }

    public void returnToMenu() {
        setContentPane(this);
    }

    private void setContentPane (JComponent pane) {
        appFrame.setContentPane(pane);
        appFrame.invalidate();
        appFrame.validate();
    }
}
