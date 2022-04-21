package com.treathunter.ui.billPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BillElementsListPane extends JPanel {
    private ArrayList<BillElementPane> billElements = new ArrayList<BillElementPane>();
    private JPanel insidePanel;
    private JScrollPane scroll;
    private JLabel billAmount;
    private JLabel billCost;
    public BillElementsListPane () {
        this.setBorder(BorderFactory.createTitledBorder("элементы"));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        insidePanel = new JPanel();
        insidePanel.setLayout(new BoxLayout(insidePanel,BoxLayout.PAGE_AXIS));
        scroll = new JScrollPane();
        scroll.setViewportView(insidePanel);
        scroll.setPreferredSize(new Dimension(1200,500));

        billAmount = new JLabel("0");
        billCost = new JLabel("0 руб.");
        JPanel summary = new JPanel();
        summary.add(new JLabel("                                                                                                       Количество товаров: "));
        summary.add(billAmount);
        summary.add(new JLabel("           Общая цена: "));
        summary.add(billCost);

        this.add(scroll);
        this.add(summary);
        this.validate();
        this.updateUI();
    }

    public void addElement(String name, String type, String price){
        BillElementPane billElementPane = new BillElementPane(name, type, price);
        billElements.add(billElementPane);
        insidePanel.add(billElementPane);
        scroll.setViewportView(insidePanel);
        billAmount.setText(String.valueOf(billElements.size()));
        Double summCost = billElements.stream().collect(Collectors.summingDouble(BillElementPane::getPriceVal));
        billCost.setText(summCost + " руб.");
        this.revalidate();
        this.updateUI();
    }

    public void deleteAllElements() {
        billAmount.setText("0");
        billCost.setText("0 руб.");
        billElements.forEach(el -> el.setVisible(false));
        billElements.clear();
        this.revalidate();
        this.updateUI();
    }
}
