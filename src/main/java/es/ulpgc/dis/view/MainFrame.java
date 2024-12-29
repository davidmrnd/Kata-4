package es.ulpgc.dis.view;

import es.ulpgc.dis.control.HistogramTsvGenerator;
import es.ulpgc.dis.model.Movie;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame {

    public MainFrame(List<Movie> movies) {
        HistogramTsvGenerator histogramTsvGenerator = new HistogramTsvGenerator(movies);
        Map<String, Integer> genreFrequencies = histogramTsvGenerator.generateHistogram();

        BarChartHistogram barChart = new BarChartHistogram();
        JFreeChart chart = barChart.createChart(genreFrequencies);

        barChart.displayChart(chart);
    }
}
