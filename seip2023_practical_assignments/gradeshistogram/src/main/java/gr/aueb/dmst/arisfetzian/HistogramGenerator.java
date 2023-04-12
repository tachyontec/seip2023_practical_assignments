package gr.aueb.dmst.arisfetzian;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * This will be used as the main class of the "gradeshistogram" module
 */
public class HistogramGenerator {

    /**
     * This is the main method which will create the array from the grades file
     * And then will generate a histogram based on that file
     *
     * @param args [0] : Accept filename from user
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("The program need to accept the filename as an argument");
            System.out.println("Closing ...");
            System.exit(0);
        } else {
	    File temp = new File(args[0]);
	    if (! temp.exists()){
	        System.out.println("Could not find this file");
		System.out.println("Closing ...");
		System.exit(0);
	    }
	}
        int[] grades_array = grades(args[0]);

        HistogramGenerator hist = new HistogramGenerator();
        hist.generateHistogram(grades_array);
    }

    /**
     * This class is accepting an array with integers (grades from 0-10)
     * and generate a histogram with their frequencies
     * @param gradesArray : The array with all grades
     */
    public void generateHistogram(int[] gradesArray) {

        //Create the frequencies from gradesArray
        int[] freq = new int[11];
        for (int i : gradesArray) {
            freq[i]++; //we have an extra grade i
        }


        // Create a dataset to store the grades dat

        //XYSeriesCollection dataset = new XYSeriesCollection();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < freq.length; i++) {
            dataset.addValue(freq[i], (Integer) 0, (Integer) i);
        }


        boolean legend = false; // do not visualize a legend
        boolean tooltips = false; // do not visualize tooltips
        boolean urls = false; // do not visualize urls

        // Create a histogram chart
        // Declare and initialize a createXYLineChart JFreeChart
        JFreeChart chart = ChartFactory.createBarChart("Chart title",
                "x_axis title",
                "y_axis_title",
                dataset,
                PlotOrientation.VERTICAL, legend, tooltips, urls);


        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        // makes the previously created frame visible
        frame.setVisible(true);
    }

    /**
     * This method accepts a text file which has one number in each line
     * and saves this in an array
     *
     * @param filename : Accepted from args[]
     * @return The java array with the grades
     */
    public static int[] grades(String filename) {
        ArrayList<Integer> grades = new ArrayList<>(); // create an ArrayList to store the grades
        //Try to read the input file
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Read each number and parse into integer
                int grade = Integer.parseInt(line.trim());
                grades.add(grade); // add grade
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Return primitive int[]
        return grades.stream().mapToInt(i -> i).toArray();

    }
}
