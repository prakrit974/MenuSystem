package sample;

import javafx.scene.chart.XYChart;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    private FileStruct fileStruct = new FileStruct();

    public FileReader(String filename) throws IOException {
        this.fileStruct.setFileName(filename);

        File file = new File(filename);
        Scanner scan = new Scanner(file);
        int seriesId = -1;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            if (line.equals("stageTitle")) {
                line = scan.nextLine();
                this.fileStruct.setStageTitle(line);
            }

            if (line.equals("chartTitle")) {
                line = scan.nextLine();
                this.fileStruct.setChartTitle(line);
            }

            if (line.equals("xAxisLabel")) {
                line = scan.nextLine();
                this.fileStruct.setxAxisLabel(line);
            }

            if (line.equals("yAxisLabel")) {
                line = scan.nextLine();
                this.fileStruct.setyAxisLabel(line);
            }

            if (line.equals("series")) {
                seriesId++;
                this.fileStruct.getListSeries().add(new XYChart.Series());
                this.fileStruct.getListSeries().get(seriesId).setName(scan.nextLine());
            }

            if (line.split("\\[")[0].equals("Data")) {
                String[] splitLine = line.split("\\[");
                String[] splitLineRest = splitLine[1].split(",");
                this.fileStruct.getListSeries().get(seriesId).getData().add(new XYChart.Data( Integer.parseInt(splitLineRest[0]), Integer.parseInt(splitLineRest[1])));
            }
        }
    }

    public FileStruct getFileStruct() { return fileStruct; }

}
