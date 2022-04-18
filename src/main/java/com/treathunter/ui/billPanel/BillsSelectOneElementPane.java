package com.treathunter.ui.billPanel;

import com.treathunter.rest.entities.Cloth;
import com.treathunter.rest.entities.Weapon;
import com.treathunter.ui.tablesPanels.clothes.UpdateClothDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BillsSelectOneElementPane extends JDialog {
    private boolean createdEntity = false;
    private Integer selectedType = -1;
    private Cloth clothRes = null;
    private Weapon weaponRes = null;
    public BillsSelectOneElementPane (JFrame owner, List<Cloth> cloths, List<Weapon> weapons) {
        super(owner,"Найденно более одного элемента с данным баркодом,необходимо выбрать 1",true);
        String[] columns = {"Имя","Тип","Цена"};
        String[][] data = new String[cloths.size() + weapons.size()][3];
        final int[] curIndex = {0};
        cloths.stream().forEach(e -> {
            data[curIndex[0]][0] = e.getName();
            data[curIndex[0]][1] = e.getClothType().getName();
            data[curIndex[0]][2] = String.valueOf(e.getPrice());
            curIndex[0]++;
        });
        weapons.stream().forEach(e -> {
            data[curIndex[0]][0] = e.getName();
            data[curIndex[0]][1] = e.getWeaponType().getName();
            data[curIndex[0]][2] = String.valueOf(e.getPrice());
            curIndex[0]++;
        });

        JTable jt=new JTable(data,columns);
        jt.setBounds(0,0,400,300);
        JScrollPane sp=new JScrollPane(jt);

        JButton btnCancel = new JButton("Отмена");
        btnCancel.addActionListener(event -> {
            createdEntity = false;
            dispose();
        });

        JButton btnAccept = new JButton("Принять");
        btnAccept.addActionListener(event -> {
            int selectedRow = jt.getSelectedRow();
            if (selectedRow != -1) {
                if (selectedRow < cloths.size()) {
                    clothRes = cloths.get(selectedRow);
                    selectedType = 0;
                } else {
                    weaponRes = weapons.get(selectedRow - cloths.size());
                    selectedType = 1;
                }
            } else {
                JOptionPane.showMessageDialog(owner,
                        "Не выбран элемент",
                        "Не выбран элемент",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            createdEntity = true;
            dispose();
        });

        JPanel bp = new JPanel();
        bp.add(btnCancel);
        bp.add(btnAccept);

        getContentPane().add(sp, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(owner);
    }
    public boolean isCreatedEntity(){
        return createdEntity;
    }

    public int getSelectedType() {return selectedType;}

    public Cloth getClothRes() {
        return clothRes;
    }

    public Weapon getWeaponRes() {
        return weaponRes;
    }
}
