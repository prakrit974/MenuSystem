package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Fausses données
        ArrayList<XYChart.Series> listSeries = new ArrayList<XYChart.Series>();

        for (int i = 0; i < 5; i++) {
            listSeries.add(new XYChart.Series());
            listSeries.get(i).setName("Serie N° " + Integer.toString(i + 1));
            for (int j = 0; j < 12; j++) {
                listSeries.get(i).getData().add(new XYChart.Data(Integer.toString(j + 1), 5 + Math.random() * 10));
            }
        }

        // Création de la LineChartView
        primaryStage.setTitle("Line Chart Sample");

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("Fruit rate, 2019");

        for (int seriesNb = 0; seriesNb < listSeries.size(); seriesNb++) {
            lineChart.getData().addAll(listSeries.get(seriesNb));
        }

        // Menu

        final MenuBar menuBar = new MenuBar();
        final BorderPane root = new BorderPane();

        root.setCenter(lineChart);
        root.setTop(menuBar);

        final Menu fileMenu = new Menu("Fichier");
        final MenuItem openItem = new MenuItem("Ouvrir");
        final MenuItem saveItem = new MenuItem("Sauvegarder");
        fileMenu.getItems().setAll(openItem, saveItem);


        final Menu displayMenu = new Menu("Affichage");

        for (int seriesNb = 0; seriesNb < listSeries.size(); seriesNb++) {
            CheckMenuItem bufferMenuItem = new CheckMenuItem(listSeries.get(seriesNb).getName());
            bufferMenuItem.setSelected(true);
            displayMenu.getItems().add(bufferMenuItem);
        }

        final Menu helpMenu = new Menu("Aide");
        menuBar.getMenus().setAll(fileMenu, displayMenu, helpMenu);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String txt = ((CheckMenuItem) actionEvent.getSource()).getText();

                if (!((CheckMenuItem)actionEvent.getSource()).isSelected()) {
                    for (int i = 0; i < lineChart.getData().size(); i++) {
                        if (lineChart.getData().get(i).getName().equals(txt)) lineChart.getData().remove(i);
                    }
                }
                else {
                    for (int i=0; i < listSeries.size(); i++) {
                        if (listSeries.get(i).getName().equals(txt)) lineChart.getData().addAll(listSeries.get(i));
                    }
                }
            }
        };

        for (int seriesNb = 0; seriesNb < listSeries.size(); seriesNb++) {
            displayMenu.getItems().get(seriesNb).setOnAction(event);
        }


        // Affichage de la scene
        Scene scene  = new Scene(root,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
