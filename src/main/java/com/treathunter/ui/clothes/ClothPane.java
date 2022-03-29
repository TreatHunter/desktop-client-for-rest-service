package com.treathunter.ui.clothes;

import com.treathunter.rest.clients.BrandClient;
import com.treathunter.rest.clients.ClothClient;
import com.treathunter.rest.clients.ClothTypeClient;
import com.treathunter.rest.dto.ClothDto;
import com.treathunter.ui.ProductTypeTableModel;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ClothPane extends JPanel {
    JFrame frame;
    private ClothClient client;
    private BrandClient brandClient;
    private ClothTypeClient clothTypeClient;
    private ProductTypeTableModel<ClothDto> productTypeTableModel;
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

        addProduct.addActionListener( event -> {
            AddClothDialog addClothDialog = new AddClothDialog(frame, brandClient, clothTypeClient);
            addClothDialog.setVisible(true);
        });

        actionsButtonsPanel.add(addProduct);
        actionsButtonsPanel.add(updateProduct);
        actionsButtonsPanel.add(deleteProduct);
        this.add(actionsButtonsPanel);
    }

    public void generateProductsTable(String[] columnNames, List<ClothDto> productsList, List<Function<ClothDto, String>> productFieldsGetters) {
        productTypeTableModel = new ProductTypeTableModel<ClothDto>(columnNames,productsList,productFieldsGetters);
        productTable = new JTable(productTypeTableModel);
        this.add(new JScrollPane(productTable));
    }

    public ClothPane(JFrame frame) {
        this.frame = frame;
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
        List<Function<ClothDto,String>> brandGetters = Arrays.asList(
                (Function<ClothDto,String>) b -> String.valueOf(b.getId()),
                (Function<ClothDto,String>) b -> b.getClothType().getName(),
                (Function<ClothDto,String>) b -> b.getBrand().getName(),
                (Function<ClothDto,String>) b -> b.getName(),
                (Function<ClothDto,String>) b -> b.getSize(),
                (Function<ClothDto,String>) b -> String.valueOf(b.getPrice()),
                (Function<ClothDto,String>) b -> String.valueOf(b.getBarcode()),
                (Function<ClothDto,String>) b -> b.getStatus(),
                (Function<ClothDto,String>) b -> b.getPhotoUrl()

        );
        client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ClothClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ClothClient.class, "http://localhost:8080/clothes");

        brandClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(BrandClient.class))
                .logLevel(Logger.Level.FULL)
                .target(BrandClient.class, "http://localhost:8080/brands");

        clothTypeClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ClothTypeClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ClothTypeClient.class, "http://localhost:8080/clothtypes");

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        generateActionsButtonPanel();
        generateProductsTable(ColumnNames,client.findAll(),brandGetters);

        this.setVisible(true);
    }
}
