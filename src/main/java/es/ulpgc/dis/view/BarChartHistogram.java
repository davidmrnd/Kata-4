package es.ulpgc.dis.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.Map;

public class BarChartHistogram implements HistogramDisplay {
    @Override
    public void displayChart(JFreeChart chart) {
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.JFrame frame = new javax.swing.JFrame("Histograma de Géneros de Peliculas");
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public JFreeChart createChart(Map<String, Integer> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            dataset.addValue(entry.getValue(), entry.getKey(), entry.getKey());
        }
        return ChartFactory.createBarChart(
                "Frecuencia de Generos",
                "Genero",
                "Cantidad de Peliculas",
                dataset
        );
    }
}
