package com.treathunter.ui.billPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BillElementsListPane extends JPanel {
    private ArrayList<BillElementPane> billElements = new ArrayList<BillElementPane>();
    private JPanel insidePanel;
    private JScrollPane scroll;
    public BillElementsListPane () {
        this.setBorder(BorderFactory.createTitledBorder("элементы"));
        insidePanel = new JPanel();
        insidePanel.setLayout(new BoxLayout(insidePanel,BoxLayout.PAGE_AXIS));
        scroll = new JScrollPane();
        scroll.setViewportView(insidePanel);
        scroll.setPreferredSize(new Dimension(1200,500));
        this.add(scroll);
        this.validate();
        this.updateUI();
    }

    public void addElement(String name, String type, String price){
        BillElementPane billElementPane = new BillElementPane(name, type, price);
        billElements.add(billElementPane);
        insidePanel.add(billElementPane);
        scroll.setViewportView(insidePanel);
        this.revalidate();
        this.updateUI();
    }

    public void deleteAllElements() {
        billElements.forEach(el -> el.setVisible(false));
        billElements.clear();
        this.revalidate();
        this.updateUI();
    }
}
