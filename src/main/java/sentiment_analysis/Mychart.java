package sentiment_analysis;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Mychart {


private PieDataset createPieDataSet(String dataFileName) throws IOException {
DefaultPieDataset pieDataset = new DefaultPieDataset();

BufferedReader bReader =new BufferedReader(new FileReader(dataFileName));
String s;
while ((s=bReader.readLine())!=null){
String datavalue [] = s.split(",");
String category = datavalue[0];
String value = datavalue [1];
pieDataset.setValue(category, Double.parseDouble(value));
}
bReader.close();

return pieDataset;
}

private JFreeChart create3DPieChart(PieDataset dataset) {


JFreeChart chart = ChartFactory.createPieChart3D(
"Pie Chart", dataset, true, true, true);

PiePlot3D p = (PiePlot3D) chart.getPlot();
p.setForegroundAlpha(0.5f);
p.setBackgroundAlpha(0.2f);

chart.setBackgroundPaint(Color.white);
chart.setAntiAlias(true);
chart.setBorderVisible(false);
chart.setTextAntiAlias(true);

return chart;

}

public void saveChart(JFreeChart chart, String fileLocation) {
String fileName = fileLocation;
try {

ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 800, 600);
} catch (IOException e) {
e.printStackTrace();
System.err.println("Problem occurred creating chart.");
}
}

public static void main(String[] args) throws Exception {
Mychart chartCreator = new Mychart();

String dataFileLocation="C:\\Users\\MSN\\Desktop\\Datasets\\results.csv";

/** Create a PieDataSet* */
PieDataset pieDataset = chartCreator.createPieDataSet(dataFileLocation);

/** Create 3D Pie Chart based on this dataset* */
JFreeChart chart = chartCreator.create3DPieChart(pieDataset);

/** Define a file location to save this chart */
String fileLocation = "C:\\Users\\MSN\\Desktop\\Datasets\\demo.png";

/** Save the chart to the file system* */
chartCreator.saveChart(chart, fileLocation);

System.out.println("3D Pie Chart has been created successfully");
System.out.println("Chart has been saved to: " + fileLocation);


}
}