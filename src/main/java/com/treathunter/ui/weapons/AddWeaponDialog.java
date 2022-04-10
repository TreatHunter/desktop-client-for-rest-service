package com.treathunter.ui.weapons;

import com.treathunter.rest.entities.*;
import com.treathunter.ui.settingsEntities.brand.AddBrandDialog;
import com.treathunter.ui.settingsEntities.caliber.AddCaliberDialog;
import com.treathunter.ui.settingsEntities.clothType.AddClothTypeDialog;
import com.treathunter.ui.settingsEntities.weaponType.AddWeaponTypeDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AddWeaponDialog  extends JDialog {
    private boolean createdEntity = false;
    private Weapon weapon;

    AddWeaponDialog(JFrame owner, List<Brand> allBrands, List<WeaponType> allWeaponTypes, List<Caliber> allCalibers){
        super(owner,"Добавить новое оружие",true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
        //

        JLabel lbWeaponType = new JLabel("тип оружия: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbWeaponType, cs);

        String[] weaponTypesArray = allWeaponTypes.stream().map(b -> b.getName()).toArray(size -> new String[size]);
        JComboBox<String> weaponTypedCmb = new JComboBox<String>(weaponTypesArray);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(weaponTypedCmb, cs);

        cs.gridx = 2;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(Box.createRigidArea(new Dimension(1,1)), cs);

        JButton btnAddWeaponType = new JButton("Новый");
        cs.gridx = 3;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(btnAddWeaponType,cs);

        btnAddWeaponType.addActionListener(actionEvent -> {
            AddWeaponTypeDialog addWeaponTypeDialog = new AddWeaponTypeDialog(this);
            addWeaponTypeDialog.setVisible(true);
            if (addWeaponTypeDialog.isCreatedEntity()) {
                allWeaponTypes.add(addWeaponTypeDialog.getEntity());
                weaponTypedCmb.addItem(addWeaponTypeDialog.getEntity().getName());
                weaponTypedCmb.setSelectedIndex(weaponTypedCmb.getItemCount() - 1);
            }
        });

        JLabel lbBrand = new JLabel("бренд: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbBrand, cs);

        String[] brandsArray = allBrands.stream().map(b -> b.getName()).toArray(size -> new String[size]);
        JComboBox<String> brandCmb = new JComboBox<String>(brandsArray);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(brandCmb, cs);

        cs.gridx = 2;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(Box.createRigidArea(new Dimension(1,1)), cs);

        JButton btnAddBrand = new JButton("Новый");
        cs.gridx = 3;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(btnAddBrand,cs);

        btnAddBrand.addActionListener(actionEvent -> {
            AddBrandDialog addBrandDialog = new AddBrandDialog(this);
            addBrandDialog.setVisible(true);
            if (addBrandDialog.isCreatedEntity()) {
                allBrands.add(addBrandDialog.getEntity());
                brandCmb.addItem(addBrandDialog.getEntity().getName());
                brandCmb.setSelectedIndex(brandCmb.getItemCount() - 1);
            }
        });

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

        JLabel lbCaliber = new JLabel("Калибр: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(lbCaliber, cs);

        String[] calibersArray = allCalibers.stream().map(b -> b.getName()).toArray(size -> new String[size]);
        JComboBox<String> caliberCmb = new JComboBox<String>(calibersArray);
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(caliberCmb, cs);

        cs.gridx = 2;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(Box.createRigidArea(new Dimension(1,1)), cs);

        JButton btnAddCaliber = new JButton("Новый");
        cs.gridx = 3;
        cs.gridy = 3;
        cs.gridwidth = 1;
        panel.add(btnAddCaliber,cs);

        btnAddCaliber.addActionListener(actionEvent -> {
            AddCaliberDialog addCaliberDialog = new AddCaliberDialog(this);
            addCaliberDialog.setVisible(true);
            if (addCaliberDialog.isCreatedEntity()) {
                allCalibers.add(addCaliberDialog.getEntity());
                caliberCmb.addItem(addCaliberDialog.getEntity().getName());
                caliberCmb.setSelectedIndex(caliberCmb.getItemCount() - 1);
            }
        });

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
        btnAccept.addActionListener(event -> {
            weapon = new Weapon();
            weapon.setWeaponType(allWeaponTypes.get(weaponTypedCmb.getSelectedIndex()));
            weapon.setBrand(allBrands.get(brandCmb.getSelectedIndex()));
            weapon.setCaliber(allCalibers.get(caliberCmb.getSelectedIndex()));
            if (tfName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(owner,
                        "Некоректный ввод названия",
                        "Некоректный ввод названия",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            weapon.setName(tfName.getText());

            try {
                weapon.setPrice(Double.valueOf(tfPrice.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(owner,
                        "Некоректный ввод цены",
                        "Некоректный ввод цены",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                weapon.setBarcode(Long.valueOf(tfBarcode.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(owner,
                        "Некоректный ввод баркода",
                        "Некоректный ввод баркода",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (tfStatus.getText().isEmpty()) {
                JOptionPane.showMessageDialog(owner,
                        "Некоректный ввод статуса",
                        "Некоректный ввод статуса",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            weapon.setStatus(tfStatus.getText());
            weapon.setPhotoUrl("");
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

    public Weapon getEntity() {
        return weapon;
    }
}