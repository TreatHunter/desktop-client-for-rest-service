package com.treathunter.ui.tablesPanels.clothes;

import com.treathunter.rest.entities.Brand;
import com.treathunter.rest.entities.Cloth;
import com.treathunter.rest.entities.ClothType;
import com.treathunter.ui.tablesPanels.settingsEntities.brand.AddBrandDialog;
import com.treathunter.ui.tablesPanels.settingsEntities.clothType.AddClothTypeDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UpdateClothDialog extends JDialog {
    private boolean createdEntity = false;
    private Cloth cloth;

    UpdateClothDialog(Cloth oldCloth, JFrame owner, List<Brand> allBrands, List<ClothType> allClothTypes){
        super(owner,"Изменить параметры одежды",true);
        cloth = oldCloth;
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
        //

        JLabel lbClothType = new JLabel("тип одежды: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbClothType, cs);

        String[] clothTypesArray = allClothTypes.stream().map(b -> b.getName()).toArray(size -> new String[size]);
        JComboBox<String> clothTypedCmb = new JComboBox<String>(clothTypesArray);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(clothTypedCmb, cs);

        int clothTypeIndex = allClothTypes.indexOf(allClothTypes
                .stream()
                .filter( el -> cloth.getClothType().getId() == el.getId())
                .findAny()
                .orElse(null));
        clothTypedCmb.setSelectedIndex(clothTypeIndex);

        cs.gridx = 2;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(Box.createRigidArea(new Dimension(1,1)), cs);

        JButton btnAddClothType = new JButton("Новый");
        cs.gridx = 3;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(btnAddClothType,cs);

        btnAddClothType.addActionListener(actionEvent -> {
            AddClothTypeDialog addClothTypeDialog = new AddClothTypeDialog(this);
            addClothTypeDialog.setVisible(true);
            if (addClothTypeDialog.isCreatedEntity()) {
                allClothTypes.add(addClothTypeDialog.getEntity());
                clothTypedCmb.addItem(addClothTypeDialog.getEntity().getName());
                clothTypedCmb.setSelectedIndex(clothTypedCmb.getItemCount() - 1);
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
        int brandIndex = allBrands.indexOf(allBrands
                .stream()
                .filter( el -> cloth.getBrand().getId() == el.getId())
                .findAny()
                .orElse(null));
        brandCmb.setSelectedIndex(brandIndex);

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
        tfName.setText(cloth.getName());

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
        tfSize.setText(cloth.getSize());

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
        tfPrice.setText(String.valueOf(cloth.getPrice()));

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
        tfBarcode.setText(String.valueOf(cloth.getBarcode()));

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
        tfStatus.setText(cloth.getStatus());
//
        JButton btnAccept = new JButton("Принять");
        btnAccept.addActionListener(event -> {
            cloth = new Cloth();
            cloth.setClothType(allClothTypes.get(clothTypedCmb.getSelectedIndex()));
            cloth.setBrand(allBrands.get(brandCmb.getSelectedIndex()));
            if (tfName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(owner,
                        "Некоректный ввод названия",
                        "Некоректный ввод названия",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            cloth.setName(tfName.getText());

            if (tfSize.getText().isEmpty()) {
                JOptionPane.showMessageDialog(owner,
                        "Некоректный ввод размера",
                        "Некоректный ввод размера",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            cloth.setSize(tfSize.getText());

            try {
                cloth.setPrice(Double.valueOf(tfPrice.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(owner,
                        "Некоректный ввод цены",
                        "Некоректный ввод цены",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                cloth.setBarcode(Long.valueOf(tfBarcode.getText()));
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
            cloth.setStatus(tfStatus.getText());
            cloth.setPhotoUrl("");
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

    public Cloth getEntity() {
        return cloth;
    }
}
