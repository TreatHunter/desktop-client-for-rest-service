package com.treathunter.ui.tablesPanels.weapons;

import com.treathunter.rest.entities.Weapon;
import com.treathunter.rest.services.WeaponsService;
import com.treathunter.ui.menuPanel.MenuPanel;
import com.treathunter.ui.tablesPanels.ProductTypeTableModel;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class WeaponsPane extends JPanel {
    private final WeaponsService weaponsService;
    private final MenuPanel menuPanel;
    private JFrame appframe;
    private ProductTypeTableModel<Weapon> productTypeTableModel;
    private JTable productTable;
    private JPanel actionsButtonsPanel;
    private JButton addProduct;
    private JButton updateProduct;
    private JButton deleteProduct;

    public void generateActionsButtonPanel() {
        actionsButtonsPanel = new JPanel();
        JButton returnButton = new JButton("Меню");
        returnButton.addActionListener( e -> menuPanel.returnToMenu());
        addProduct = new JButton("добaвить");
        updateProduct = new JButton("изменить");
        deleteProduct = new JButton("удaлить");

        addProduct.addActionListener( actionEvent -> {
            AddWeaponDialog addWeaponDialog = new AddWeaponDialog(
                    appframe,
                    weaponsService.getAllBrands(),
                    weaponsService.getAllWeaponTypes(),
                    weaponsService.getAllCalibers()
            );
            addWeaponDialog.setVisible(true);
            if (addWeaponDialog.isCreatedEntity()) {
                weaponsService.addWeapon(addWeaponDialog.getEntity());
                productTypeTableModel.updateTable(weaponsService.getAllWeapons());
            }
        });

        deleteProduct.addActionListener(actionEvent -> {
            if (productTable.getSelectedRow() != -1) {
                String weaponId = productTable.getValueAt(productTable.getSelectedRow(),0).toString();
                weaponsService.deleteWeapon(weaponId);
                productTypeTableModel.updateTable(weaponsService.getAllWeapons());
            } else {
                JOptionPane.showMessageDialog(appframe,
                        "Не выбран элемент для удаления",
                        "Не выбран элемент для удаления",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        updateProduct.addActionListener(actionEvent -> {
            if (productTable.getSelectedRow() != -1) {
                String weaponId = productTable.getValueAt(productTable.getSelectedRow(),0).toString();
                UpdateWeaponDialog updateWeaponDialog = new UpdateWeaponDialog(
                        weaponsService.getWeaponById(weaponId),
                        appframe,
                        weaponsService.getAllBrands(),
                        weaponsService.getAllWeaponTypes(),
                        weaponsService.getAllCalibers()
                );;
                updateWeaponDialog.setVisible(true);
                if (updateWeaponDialog.isCreatedEntity()) {
                    weaponsService.updateWeapon(weaponId,updateWeaponDialog.getEntity());
                    productTypeTableModel.updateTable(weaponsService.getAllWeapons());
                }
            } else {
                JOptionPane.showMessageDialog(appframe,
                        "Не выбран элемент для изменения",
                        "Не выбран элемент для изменения",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        actionsButtonsPanel.add(returnButton);
        actionsButtonsPanel.add(addProduct);
        actionsButtonsPanel.add(updateProduct);
        actionsButtonsPanel.add(deleteProduct);
        actionsButtonsPanel.setBorder(BorderFactory.createTitledBorder("панель управления"));
        this.add(actionsButtonsPanel);
    }

    public void generateProductsTable(String[] columnNames, List<Weapon> productsList, List<Function<Weapon, String>> productFieldsGetters) {
        productTypeTableModel = new ProductTypeTableModel<Weapon>(columnNames,productsList,productFieldsGetters);
        productTable = new JTable(productTypeTableModel);
        this.add(new JScrollPane(productTable));
    }

    public WeaponsPane(WeaponsService weaponsService, JFrame appframe,MenuPanel menuPanel) {
        this.weaponsService = weaponsService;
        this.appframe = appframe;
        this.menuPanel = menuPanel;
        String[] ColumnNames = {
                "id",
                "weaponType",
                "brand",
                "name",
                "caliber",
                "price",
                "barcode",
                "status",
                "photoUrl"
        };
        List<Function<Weapon,String>> brandGetters = Arrays.asList(
                (Function<Weapon,String>) b -> String.valueOf(b.getId()),
                (Function<Weapon,String>) b -> b.getWeaponType().getName(),
                (Function<Weapon,String>) b -> b.getBrand().getName(),
                (Function<Weapon,String>) b -> b.getName(),
                (Function<Weapon,String>) b -> b.getCaliber().getName(),
                (Function<Weapon,String>) b -> String.valueOf(b.getPrice()),
                (Function<Weapon,String>) b -> String.valueOf(b.getBarcode()),
                (Function<Weapon,String>) b -> b.getStatus(),
                (Function<Weapon,String>) b -> b.getPhotoUrl()

        );


        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        generateActionsButtonPanel();
        generateProductsTable(ColumnNames, weaponsService.getAllWeapons(),brandGetters);

        this.setVisible(true);
    }
}

