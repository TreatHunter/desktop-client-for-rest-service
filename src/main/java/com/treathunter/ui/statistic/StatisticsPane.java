package com.treathunter.ui.statistic;

import com.github.lgooddatepicker.components.DatePicker;
import com.treathunter.rest.entities.Operation;
import com.treathunter.rest.entities.ProductsArchive;
import com.treathunter.rest.services.OperationService;
import com.treathunter.ui.billPanel.BillElementPane;
import com.treathunter.ui.menuPanel.MenuPanel;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsPane extends JPanel {
    private final MenuPanel menuPanel;
    private final OperationService operationService;
    private final JFrame appFrame;

    JPanel chart2Panel;
    public StatisticsPane(MenuPanel menuPanel, OperationService operationService, JFrame appFrame) {
        this.menuPanel = menuPanel;
        this.operationService = operationService;
        this.appFrame = appFrame;

        createButtonsPanel();

        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title("Пример").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideS);
        chart.getStyler().setYAxisGroupPosition(1, Styler.YAxisPosition.Right);

        // Series
        List<Date> xData1 = new ArrayList<Date>();
        List<Double> yData1 = new ArrayList<Double>();
        List<Date> xData2 = new ArrayList<Date>();
        List<Double> yData2 = new ArrayList<Double>();

        Random random = new Random();

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS");
        Date date = null;
        for (int i = 1; i <= 10; i++) {
            try {
                date =
                        sdf.parse(
                                "2013-"+(1+i)+"-22-08:"
                                        + (5 * i + random.nextInt(2))
                                        + ":"
                                        + (random.nextInt(2))
                                        + "."
                                        + random.nextInt(1000));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // System.out.println(date.getTime());
            // System.out.println(date.toString());
            xData1.add(date);
            xData2.add(date);
            yData1.add(Math.random() * i * 1000000000);
            yData2.add(Math.random() * i * 10);
        }

        chart.addSeries("series1", xData1, yData1).setYAxisGroup(1);
        chart.addSeries("series2", xData2, yData2);
        chart2Panel = new XChartPanel<XYChart>(chart);
        this.add(chart2Panel);
    }

    private void createButtonsPanel () {
        JPanel actionsButtonsPanel = new JPanel();
        JButton returnButton = new JButton("Меню");
        returnButton.addActionListener( e -> menuPanel.returnToMenu());

        JLabel productSelectLb = new JLabel("Тип товавра:");

        String[] productTypes = operationService.getCategories().stream().map(b -> b.getName()).toArray(size -> new String[size]);
        JComboBox<String> productSelectJCmb = new JComboBox<String>(productTypes);

        JLabel dateStartLb = new JLabel("Дата: c");
        DatePicker datePickerStart = new DatePicker();
        JLabel dateEndLb = new JLabel("Дата: до");
        DatePicker datePickerEnd = new DatePicker();

        JButton showButton = new JButton("Показать");
        showButton.addActionListener( e -> {
            generateData(productSelectJCmb.getItemAt(productSelectJCmb.getSelectedIndex()),datePickerStart.getDate(),datePickerEnd.getDate());
        });

        actionsButtonsPanel.add(returnButton);
        actionsButtonsPanel.add(productSelectLb);
        actionsButtonsPanel.add(productSelectJCmb);
        actionsButtonsPanel.add(dateStartLb);
        actionsButtonsPanel.add(datePickerStart);
        actionsButtonsPanel.add(dateEndLb);
        actionsButtonsPanel.add(datePickerEnd);
        actionsButtonsPanel.add(showButton);
        actionsButtonsPanel.setBorder(BorderFactory.createTitledBorder("панель управления"));
        this.add(actionsButtonsPanel);
    }

    private void generateData (String category, LocalDate startDate, LocalDate endDate) {
        List<Operation> operationList = operationService.getOperations();

        List<Operation> filteredList = operationList.parallelStream().filter(e -> {
            boolean isSameCategory = new ArrayList<ProductsArchive>(e.getProductsArchives()).get(0).getCategory().getName().equals(category);
            boolean isAfterDateStart = LocalDateTime.parse(e.getTime(), DateTimeFormatter.ISO_DATE_TIME).toLocalDate().isAfter(startDate);
            boolean isBeforeDateEnd = LocalDateTime.parse(e.getTime(), DateTimeFormatter.ISO_DATE_TIME).toLocalDate().isBefore(endDate);
            return isSameCategory && isAfterDateStart && isBeforeDateEnd;
        }).collect(Collectors.toList());

       // Map<LocalDate,List<Operation>> map = filteredList.parallelStream().collect(Collectors.groupingBy(Operation::getTime::));
        List<Date> DatesList = new ArrayList<Date>();
        filteredList.parallelStream().forEach(el -> {
            DatesList.add(java.sql.Date.valueOf(LocalDateTime.parse(el.getTime(), DateTimeFormatter.ISO_DATE_TIME).toLocalDate()));
        });
        List<Date> xData = new ArrayList<Date>();
        List<Integer> yData = new ArrayList<Integer>();

        Map<String,List<Date>> map = DatesList.parallelStream().collect(Collectors.groupingBy(Date::toString));
        List<String> sortedList = new ArrayList<>(map.keySet());
        Collections.sort(sortedList);
        for(String dateStr : sortedList){
            xData.add(java.sql.Date.valueOf(LocalDate.parse(dateStr)));
            yData.add(map.get(dateStr).size());
        }
        double price = 0;
        for (Operation operation : filteredList) {
            price += operation.getProductsArchives().stream().collect(Collectors.summingDouble(ProductsArchive::getPrice));
        }
        drawChart(xData, yData, category, " Общий объём продаж : " + price +" руб.");
    }

    private void drawChart(List<Date> xData, List<Integer> yData, String category,String totalCost) {
        chart2Panel.setVisible(false);
        this.remove(chart2Panel);
        XYChart chart = new XYChartBuilder().width(800).height(600).title("Таблица товаров. " + totalCost).build();
        chart.addSeries(category, xData, yData);
        chart2Panel = new XChartPanel<XYChart>(chart);
        this.add(chart2Panel);
        appFrame.invalidate();
        appFrame.validate();
    }
}
