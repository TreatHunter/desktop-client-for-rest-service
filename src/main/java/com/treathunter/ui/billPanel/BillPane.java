package com.treathunter.ui.billPanel;

import com.treathunter.rest.entities.Cloth;
import com.treathunter.rest.entities.Weapon;
import com.treathunter.rest.services.ClothesService;
import com.treathunter.rest.services.OperationService;
import com.treathunter.rest.services.WeaponsService;
import com.treathunter.ui.menuPanel.MenuPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BillPane extends JPanel {
    private final MenuPanel menuPanel;
    private final BillElementsListPane billElementsListPane;
    private final JFrame appFrame;
    private final ClothesService clothesService;
    private final WeaponsService weaponsService;
    private final OperationService operationService;
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private ArrayList<Cloth> cloths = new ArrayList<Cloth>();

    private void createButtonsPanel () {
        JPanel actionsButtonsPanel = new JPanel();
        JButton returnButton = new JButton("Меню");
        returnButton.addActionListener( e -> menuPanel.returnToMenu());
        JLabel barcodeLabel = new JLabel("Поле ввода баркода");
        JTextField barcodeTextField = new JTextField("Поле ввода баркода");
        JButton findButton = new JButton("Поиск");

        findButton.addActionListener( e -> {
            String barcodeText = barcodeTextField.getText();
            if (barcodeText.isEmpty() ) {
                JOptionPane.showMessageDialog(appFrame,
                        "Некоректный ввод баркода",
                        "Некоректный ввод баркода",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Long barcode = null;
            try {
                barcode = Long.valueOf(barcodeText);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(appFrame,
                        "Некоректный ввод баркода",
                        "Некоректный ввод баркода",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Cloth> clothsRes = clothesService.getClothByBarcode(barcode);
            List<Weapon> weaponsRes = weaponsService.getWeaponByBarcode(barcode);

            List<Long> clothsIds = cloths.stream().map(el -> el.getId()).collect(Collectors.toList());
            clothsRes = clothsRes.stream().filter(el -> !clothsIds.contains(el.getId())).collect(Collectors.toList());

            List<Long> weaponsIds = weapons.stream().map(el -> el.getId()).collect(Collectors.toList());
            weaponsRes = weaponsRes.stream().filter(el -> !weaponsIds.contains(el.getId())).collect(Collectors.toList());

            Cloth clothRes = null;
            Weapon weaponRes = null;

            if (clothsRes.size() + weaponsRes.size() == 0) {
                JOptionPane.showMessageDialog(appFrame,
                        "нет товаров с таким баркодом",
                        "нет товаров с таким баркодом",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (clothsRes.size() + weaponsRes.size() > 1) {
                BillsSelectOneElementPane billsSelectOneElementPane = new BillsSelectOneElementPane(appFrame,clothsRes,weaponsRes);
                billsSelectOneElementPane.setVisible(true);
                if (billsSelectOneElementPane.isCreatedEntity()) {
                    if (billsSelectOneElementPane.getSelectedType() == 0) {
                        clothRes = billsSelectOneElementPane.getClothRes();
                    } else {
                        weaponRes = billsSelectOneElementPane.getWeaponRes();
                    }
                } else {
                    return;
                }
            } else {
                if (clothsRes.size() != 0) {
                    clothRes = clothsRes.get(0);
                } else {
                    weaponRes = weaponsRes.get(0);
                }
            }

            if (clothRes != null) {
                cloths.add(clothRes);
                billElementsListPane.addElement(clothRes.getName(),clothRes.getClothType().getName(),String.valueOf(clothRes.getPrice()));
            } else {
                weapons.add(weaponRes);
                billElementsListPane.addElement(weaponRes.getName(),weaponRes.getWeaponType().getName(),String.valueOf(weaponRes.getPrice()));
            }

        });

        actionsButtonsPanel.add(returnButton);
        actionsButtonsPanel.add(barcodeLabel);
        actionsButtonsPanel.add(barcodeTextField);
        actionsButtonsPanel.add(findButton);
        actionsButtonsPanel.setBorder(BorderFactory.createTitledBorder("панель управления"));
        this.add(actionsButtonsPanel);
    }

    public BillPane(JFrame appFrame, MenuPanel menuPanel, ClothesService clothesService, WeaponsService weaponsService, OperationService operationService) {
        this.menuPanel = menuPanel;
        this.appFrame = appFrame;
        this.weaponsService = weaponsService;
        this.clothesService = clothesService;
        this.operationService = operationService;

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        createButtonsPanel();
        billElementsListPane = new BillElementsListPane();
        this.add(billElementsListPane);

        JPanel bp = new JPanel();
        JButton btnAccept = new JButton("Завершить");
        btnAccept.addActionListener(e ->{
            cloths.stream().forEach(el-> {
                clothesService.deleteCloth(String.valueOf(el.getId()));
                operationService.addBoughtOperationForCloth(el);
            });

            weapons.stream().forEach(el-> {
                weaponsService.deleteWeapon(String.valueOf(el.getId()));
                operationService.addBoughtOperationForWeapon(el);
            });
            clear();
        });
        JButton btnCancel = new JButton("Очистить");
        btnCancel.addActionListener(e -> clear());
        bp.add(btnCancel);
        bp.add(btnAccept);
        this.add(bp);
    }

    private void clear() {
        weapons = new ArrayList<Weapon>();
        cloths = new ArrayList<Cloth>();
        billElementsListPane.deleteAllElements();
    }
}
