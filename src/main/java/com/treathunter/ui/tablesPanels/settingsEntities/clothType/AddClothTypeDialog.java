package com.treathunter.ui.tablesPanels.settingsEntities.clothType;

import com.treathunter.rest.entities.ClothType;

import javax.swing.*;
import java.awt.*;

public class AddClothTypeDialog extends JDialog {
    private boolean createdEntity = false;
    private ClothType clothType;

    public AddClothTypeDialog(JDialog owner) {
        super(owner,"Добавить новый тип одежды",true);

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

        JLabel lbDescription = new JLabel("Описание: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbDescription, cs);

        JTextField tfDescription = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(tfDescription, cs);

        //
        JButton btnAccept = new JButton("Принять");
        btnAccept.addActionListener(event -> {
            clothType = new ClothType();

            if (tfName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(owner,
                        "Некоректный ввод названия",
                        "Некоректный ввод названия",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            clothType.setName(tfName.getText());

            if (tfDescription.getText().isEmpty()) {
                JOptionPane.showMessageDialog(owner,
                        "Некоректный ввод описания",
                        "Некоректный ввод описания",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            clothType.setDescription(tfDescription.getText());

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

    public ClothType getEntity() {
        return clothType;
    }

}

