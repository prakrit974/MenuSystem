package sample;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class FileStruct {
    //String fileName, String stageTitle, String chartTitle, String xAxisLabel, String yAxisLabel, ArrayList<XYChart.Series> listSeries
    private String fileName;
    private String stageTitle;
    private String chartTitle;
    private String xAxisLabel;
    private String yAxisLabel;
    private ArrayList<XYChart.Series> listSeries;

    public FileStruct(String fileName, String stageTitle, String chartTitle, String xAxisLabel, String yAxisLabel, ArrayList<XYChart.Series> listSeries) {
        this.fileName = fileName;
        this.stageTitle = stageTitle;
        this.chartTitle = chartTitle;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
        this.listSeries = listSeries;
    }

    public FileStruct() {
        this.fileName = "";
        this.stageTitle = "";
        this.chartTitle = "";
        this.xAxisLabel = "";
        this.yAxisLabel = "";
        this.listSeries = new ArrayList<XYChart.Series>();
    }

    public String getFileName() { return fileName; }
    public String getStageTitle() { return stageTitle; }
    public String getChartTitle() { return chartTitle; }
    public String getxAxisLabel() { return xAxisLabel; }
    public String getyAxisLabel() { return yAxisLabel; }
    public ArrayList<XYChart.Series> getListSeries() { return listSeries; }

    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setStageTitle(String stageTitle) { this.stageTitle = stageTitle; }
    public void setChartTitle(String chartTitle) { this.chartTitle = chartTitle; }
    public void setxAxisLabel(String xAxisLabel) { this.xAxisLabel = xAxisLabel; }
    public void setyAxisLabel(String yAxisLabel) { this.yAxisLabel = yAxisLabel; }
    public void setListSeries(ArrayList<XYChart.Series> listSeries) { this.listSeries = listSeries; }
}
