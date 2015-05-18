package ungs.edu.graficar;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

import ungs.edu.gpsfree.Coordenada;

public class Graficador extends ApplicationFrame {

	
	private XYSeriesCollection dataset;
		
	
	public Graficador(){
		super ("GRAFICO");
		this.dataset= new XYSeriesCollection();
	}
	
	public JPanel dibujar(){
		final JFreeChart chart = createChart(dataset);
      
		final ChartPanel chartPanel = new ChartPanel(chart);
       chartPanel.setPreferredSize(new java.awt.Dimension(300, 220));
        setContentPane(chartPanel);
      //  this.pack();
      //  RefineryUtilities.centerFrameOnScreen(this);
	  //  this.setVisible(true);
		return chartPanel;
	}
	
	
	public void agregarPunto(Coordenada coordenada,String nombre ){
		 XYSeries serie = new XYSeries(nombre +"["+coordenada.getX()+","+coordenada.getY()+"]");
		 serie.add(coordenada.getX(), coordenada.getY());
		this.dataset.addSeries(serie);
		
	}
	
    /**
     * Creates a chart.
     * 
     * @param dataset  the data for the chart.
     * 
     * @return a chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "GPS FREE",      // chart title
            "X",                      // x axis label
            "Y",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);
        
       // final StandardLegend legend = (StandardLegend) chart.getLegend();
       // legend.setDisplaySeriesShapes(true);
        
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        double size = 20.0;
        double delta = size / 2.0;
        Shape cross = ShapeUtilities.createDiagonalCross(3, 1);
        renderer.setSeriesShape(0, cross);
        
        //renderer.setSeriesLinesVisible(0, false);
        //renderer.setSeriesShapesVisible(1, false);
  

        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
                
        return chart;
        
    }

	
}
