package com.treathunter.ui.clothes;

import com.treathunter.rest.clients.BrandClient;
import com.treathunter.rest.clients.ClothTypeClient;

import javax.swing.*;
import java.awt.*;

public class AddClothDialog extends JDialog {

    AddClothDialog (JFrame owner, BrandClient brandClient, ClothTypeClient clothTypeClient){
        super(owner,"Добавить новую одежду",true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
 //

        JLabel lbClothType = new JLabel("тип одежды: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbClothType, cs);

        String[] clothTypesArray = clothTypeClient.findAll().stream().map(b -> b.getName()).toArray(size -> new String[size]);
        JComboBox<String> clothTypedCmb = new JComboBox<String>(clothTypesArray);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(clothTypedCmb, cs);

        JLabel lbBrand = new JLabel("бренд: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbBrand, cs);

        String[] brandsArray = brandClient.findAll().stream().map(b -> b.getName()).toArray(size -> new String[size]);
        JComboBox<String> brandCmb = new JComboBox<String>(brandsArray);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(brandCmb, cs);

        JLabel lbName = new JLabel("Название: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbName, cs);

        JTextField tfName = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(tfName, cs);

        JLabel lbSize = new JLabel("Размер: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(lbSize, cs);

        JTextField tfSize = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(tfSize, cs);

        JLabel lbPrice = new JLabel("цена: ");
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 1;
        panel.add(lbPrice, cs);

        JTextField tfPrice = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 2;
        panel.add(tfPrice, cs);

        JLabel lbBarcode = new JLabel("баркод: ");
        cs.gridx = 0;
        cs.gridy = 5;
        cs.gridwidth = 1;
        panel.add(lbBarcode, cs);

        JTextField tfBarcode = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 5;
        cs.gridwidth = 2;
        panel.add(tfBarcode, cs);

        JLabel lbStatus = new JLabel("cтатус товара: ");
        cs.gridx = 0;
        cs.gridy = 6;
        cs.gridwidth = 1;
        panel.add(lbStatus, cs);

        JTextField tfStatus = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 6;
        cs.gridwidth = 2;
        panel.add(tfStatus, cs);
//
        JButton btnAccept = new JButton("Принять");
        JButton btnCancel = new JButton("Отмена");

        JPanel bp = new JPanel();
        bp.add(btnCancel);
        bp.add(btnAccept);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
        pack();
        setResizable(false);
        setLocationRelativeTo(owner);
    }
}
