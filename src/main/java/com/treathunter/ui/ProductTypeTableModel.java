package com.treathunter.ui;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ProductTypeTableModel<T> extends AbstractTableModel {
    private final String[] columnNames;
    private final List<Function<T, String>> productFieldsGetters;
    private List<T> productsList;

    public ProductTypeTableModel(String[] columnNames, List<T> productsList, List<Function<T, String>> productFieldsGetters) {
        this.columnNames = columnNames;
        this.productsList = productsList;
        this.productFieldsGetters = productFieldsGetters;
    }

    public void updateTable(List<T> productsList){
        this.productsList = productsList;
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return String.class;
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public int getRowCount()
    {
        return productsList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        T product = productsList.get(rowIndex);
        return productFieldsGetters.get(columnIndex).apply(product);
    }

}
