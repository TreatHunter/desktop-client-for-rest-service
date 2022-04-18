package com.treathunter.ui.billPanel;

import javax.swing.*;

public class BillElementPane extends JPanel {
    private JLabel Name;
    private JLabel type;
    private JLabel price;

    public BillElementPane (String name, String type, String price) {
        this.add(new JLabel(name));
        this.add(new JLabel(type));
        this.add(new JLabel(price));
    }
}
