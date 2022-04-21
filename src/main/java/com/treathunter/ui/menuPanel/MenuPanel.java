package com.treathunter.ui.menuPanel;

import com.treathunter.rest.services.ClothesService;
import com.treathunter.rest.services.OperationService;
import com.treathunter.rest.services.WeaponsService;
import com.treathunter.ui.billPanel.BillPane;
import com.treathunter.ui.statistic.StatisticsPane;
import com.treathunter.ui.tablesPanels.TablesPane;

import javax.swing.*;

public class MenuPanel extends JPanel {
    private JFrame appFrame;
    private TablesPane tablesPane;
    private BillPane billPane;
    private StatisticsPane statisticsPane;
    public MenuPanel (JFrame frame, ClothesService clothesService, WeaponsService weaponsService, OperationService operationService) {
        appFrame = frame;
        tablesPane = new TablesPane(appFrame, clothesService, weaponsService, this);
        billPane = new BillPane(appFrame,this, clothesService, weaponsService, operationService);
        statisticsPane = new StatisticsPane(this, operationService, appFrame);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JButton tablesButton = new JButton("Работа с товарами");
        tablesButton.addActionListener(e -> {
            tablesPane = new TablesPane(appFrame, clothesService, weaponsService, this);
            setContentPane(tablesPane);
        });
        this.add(tablesButton);

        JButton billButton = new JButton("Cоздание чеков");
        billButton.addActionListener(e -> {
            billPane = new BillPane(appFrame,this, clothesService, weaponsService, operationService);
            setContentPane(billPane);
        });
        this.add(billButton);

        JButton statisticButton = new JButton("Отчетность");
        statisticButton.addActionListener(e -> {

            statisticsPane = new StatisticsPane(this, operationService, appFrame);
            setContentPane(statisticsPane);
        });
        this.add(statisticButton);


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
