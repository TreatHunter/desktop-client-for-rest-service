package com.treathunter.ui.billPanel;

import javax.swing.*;

public class BillElementPane extends JPanel {
    private JLabel Name;
    private JLabel type;
    private JLabel price;
    Double priceVal;
    public BillElementPane (String name, String type, String price) {
        priceVal = Double.valueOf(price);
        this.add(new JLabel("Имя товара: "));
        this.add(new JLabel(name));
        this.add(new JLabel("               "));
        this.add(new JLabel("Тип товара: "));
        this.add(new JLabel(type));
        this.add(new JLabel("               "));
        this.add(new JLabel("цена: "));
        this.add(new JLabel(price));
        this.setBorder(BorderFactory.createTitledBorder("товар"));
    }
    public Double getPriceVal() {
        return priceVal;
    }
}
