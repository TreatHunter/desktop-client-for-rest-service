package com.treathunter.ui.settingsEntities.brand;

import com.treathunter.rest.entities.Brand;

import javax.swing.*;
import java.awt.*;

public class AddBrandDialog extends JDialog {
    private boolean createdEntity = false;
    private Brand brand;

    public AddBrandDialog(JDialog owner) {
        super(owner,"Добавить новый бренд",true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
        //
        JLabel lbName = new JLabel("Название: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbName, cs);

        JTextField tfName = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfName, cs);

        //
        JButton btnAccept = new JButton("Принять");
        btnAccept.addActionListener(event -> {
            brand = new Brand();

            if (tfName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(owner,
                        "Некоректный ввод названия",
                        "Некоректный ввод названия",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            brand.setName(tfName.getText());
            brand.setLogoUrl("");

            createdEntity = true;
            dispose();
        });

        JButton btnCancel = new JButton("Отмена");
        btnCancel.addActionListener(event -> {
            createdEntity = false;
            dispose();
        });


        JPanel bp = new JPanel();
        bp.add(btnCancel);
        bp.add(btnAccept);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
        pack();
        setResizable(false);
        setLocationRelativeTo(owner);
    }

    public boolean isCreatedEntity(){
        return createdEntity;
    }

    public Brand getEntity() {
        return brand;
    }

}
