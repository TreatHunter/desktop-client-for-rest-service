package com.treathunter.ui.clothes;

import com.treathunter.rest.entities.Cloth;
import com.treathunter.rest.services.ClothesService;
import com.treathunter.ui.ProductTypeTableModel;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ClothesPane extends JPanel {
    private final ClothesService clothesService;
    private JFrame appframe;
    private ProductTypeTableModel<Cloth> productTypeTableModel;
    private JTable productTable;
    private JPanel actionsButtonsPanel;
    private JButton addProduct;
    private JButton updateProduct;
    private JButton deleteProduct;

    public void generateActionsButtonPanel() {
        actionsButtonsPanel = new JPanel();
        addProduct = new JButton("добaвить");
        updateProduct = new JButton("изменить");
        deleteProduct = new JButton("удaлить");

        addProduct.addActionListener( actionEvent -> {
            AddClothDialog addClothDialog = new AddClothDialog(appframe, clothesService.getAllBrands(), clothesService.getAllClothTypes());
            addClothDialog.setVisible(true);
            if (addClothDialog.isCreatedEntity()) {
                clothesService.addCloth(addClothDialog.getEntity());
                productTypeTableModel.updateTable(clothesService.getAllClothes());
            }
        });

        deleteProduct.addActionListener(actionEvent -> {
            if (productTable.getSelectedRow() != -1) {
                clothesService.deleteCloth(productTable.getValueAt(productTable.getSelectedRow(),0).toString());
                productTypeTableModel.updateTable(clothesService.getAllClothes());
            } else {
                JOptionPane.showMessageDialog(appframe,
                        "Не выбран элемент для удаления",
                        "Не выбран элемент для удаления",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        updateProduct.addActionListener(actionEvent -> {
            if (productTable.getSelectedRow() != -1) {
                String clothId = productTable.getValueAt(productTable.getSelectedRow(),0).toString();
                UpdateClothDialog updateClothDialog = new UpdateClothDialog(clothesService.getClothById(clothId),
                        appframe,
                        clothesService.getAllBrands(),
                        clothesService.getAllClothTypes());
                updateClothDialog.setVisible(true);
                if (updateClothDialog.isCreatedEntity()) {
                    clothesService.updateCloth(clothId,updateClothDialog.getEntity());
                    productTypeTableModel.updateTable(clothesService.getAllClothes());
                }
            } else {
                JOptionPane.showMessageDialog(appframe,
                        "Не выбран элемент для изменения",
                        "Не выбран элемент для изменения",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        actionsButtonsPanel.add(addProduct);
        actionsButtonsPanel.add(updateProduct);
        actionsButtonsPanel.add(deleteProduct);
        this.add(actionsButtonsPanel);
    }

    public void generateProductsTable(String[] columnNames, List<Cloth> productsList, List<Function<Cloth, String>> productFieldsGetters) {
        productTypeTableModel = new ProductTypeTableModel<Cloth>(columnNames,productsList,productFieldsGetters);
        productTable = new JTable(productTypeTableModel);
        this.add(new JScrollPane(productTable));
    }

    public ClothesPane(ClothesService clothesService, JFrame appframe) {
        this.clothesService = clothesService;
        this.appframe = appframe;

        String[] ColumnNames = {
                "id",
                "clothType",
                "brand",
                "name",
                "size",
                "price",
                "barcode",
                "status",
                "photoUrl"
        };
        List<Function<Cloth,String>> brandGetters = Arrays.asList(
                (Function<Cloth,String>) b -> String.valueOf(b.getId()),
                (Function<Cloth,String>) b -> b.getClothType().getName(),
                (Function<Cloth,String>) b -> b.getBrand().getName(),
                (Function<Cloth,String>) b -> b.getName(),
                (Function<Cloth,String>) b -> b.getSize(),
                (Function<Cloth,String>) b -> String.valueOf(b.getPrice()),
                (Function<Cloth,String>) b -> String.valueOf(b.getBarcode()),
                (Function<Cloth,String>) b -> b.getStatus(),
                (Function<Cloth,String>) b -> b.getPhotoUrl()

        );


        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        generateActionsButtonPanel();
        generateProductsTable(ColumnNames, clothesService.getAllClothes(),brandGetters);

        this.setVisible(true);
    }
}
