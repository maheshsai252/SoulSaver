/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author maheshsai
 */
public class SaveCharts {
    public static String saveChart(String fp, JFreeChart chart) {
        try {
            String afilePath = new File("").getAbsolutePath();
            String filePath =  fp+"/revenue.png";
            ChartUtilities.saveChartAsPNG(new File(filePath), chart, 600, 300);
            return "Saved Successfully";
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return ex.getMessage();
        }

    }
}
