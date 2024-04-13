package GUI;

import Task2.Item2d;
import Task3.View;
import Task3.ViewResult;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;

  /** Створення вікна для відображення графіку
   * 
   * @author Яценко Віталій
   */
public class Graphic extends JFrame {

    private XYSeries survSeries;
    private XYSeries primSeries;

    /** Створення вікна з графіком */
    public Graphic(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        XYSeriesCollection dataset = new XYSeriesCollection();
        survSeries = new XYSeries("Amount of surviving cells");
        primSeries = new XYSeries("Amount of primary cells");
        dataset.addSeries(survSeries);
        dataset.addSeries(primSeries);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Surviving cell's chart",
                "Amount of cycles",
                "Amount of cells",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        this.add(chartPanel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.setSize(960, 720);
        customizeGraph(chart);
    }

    /** Оновлення графіку при оновленні даних
     * @param view – нові дані для графіку
     */
    protected void updateGraph(View view) {
        survSeries.clear();
        primSeries.clear();

        for (Item2d item : ((ViewResult) view).getItems()) {
            primSeries.add(item.getCycles(), item.getPCells());
            survSeries.add(item.getCycles(), item.getSCells());
        }
        this.repaint();
    }

    /** Створення графіку
     * @param view – нові дані для графіку
     */
    protected void addData(View view) {
        for (Item2d item : ((ViewResult) view).getItems()) {
            primSeries.add(item.getCycles(), item.getPCells());
            survSeries.add(item.getCycles(), item.getSCells());
        }
    }

    /** Задання зовнішнього вигляду графіку
     * @param chart – графік
     */
    protected void customizeGraph(JFreeChart chart) {
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.RED);

        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));

        renderer.setBaseToolTipGenerator(new XYToolTipGenerator() {
            @Override
            public String generateToolTip(XYDataset dataset, int series, int item) {
                int x = (int) dataset.getXValue(series, item);
                int y = (int) dataset.getYValue(series, item);
                return "Cycles: " + x + ", Cells: " + y;
            }
        });

        plot.setRenderer(renderer);

        plot.setBackgroundPaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);
    }
}
