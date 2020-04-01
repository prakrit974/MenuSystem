package sample;

import javafx.scene.chart.XYChart;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileMaker {

    public FileMaker(FileStruct fileStruct) throws IOException {

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileStruct.getFileName())));

        printWriter.println("stageTitle");
        printWriter.println(fileStruct.getStageTitle());

        printWriter.println("chartTitle");
        printWriter.println(fileStruct.getChartTitle());

        printWriter.println("xAxisLabel");
        printWriter.println(fileStruct.getxAxisLabel());

        printWriter.println("yAxisLabel");
        printWriter.println(fileStruct.getyAxisLabel());

        for (int i = 0; i < fileStruct.getListSeries().size(); i++) {
            printWriter.println("series");
            printWriter.println(fileStruct.getListSeries().get(i).getName());
            for (int j = 0; j < fileStruct.getListSeries().get(i).getData().size(); j++) {
                printWriter.println(fileStruct.getListSeries().get(i).getData().get(j));
            }
        }

        printWriter.close();
    }
}
