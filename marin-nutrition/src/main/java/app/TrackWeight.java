package app;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class TrackWeight {

    // This csv file will store the unit of measurements (imperial/metric)
    // and the height and weight in the order unit,weight
    static File filePath = new File("src/main/resources/measurements.csv");

    // Take the height and weight of the user and the unit of measurement they will be using
    // Does not allow weight below 0
    // Does not allow weights above 600 lbs or 275 kg
    public void recordWeight(String unit, float weight) throws IOException {
        // Checks to see if unit is valid
        if (!unit.equals("imperial")  && !unit.equals("metric"))
            throw new IllegalArgumentException("Unit not valid.");

        // Checks to see if weight is valid
        if (weight < 0)
            throw new IllegalArgumentException("Weight not valid.");
        else if (unit.equals("metric") && weight > 275)
            throw new IllegalArgumentException("Weight not valid.");
        else if (unit.equals("imperial") && weight > 600)
            throw new IllegalArgumentException("Weight not valid.");

        try {
            //FileWriter outputFile = ;
            CSVWriter writer = new CSVWriter(new FileWriter(filePath));

            String weightString = Float.toString(weight);

            String[] measurements = {unit, weightString};
            writer.writeNext(measurements);

            writer.close();

        } catch (IOException e) {
            System.out.println("There was an issue with recording your weight.");
        }
    }

    public String returnWeight() {
        // Read the weight and unit from measurements.csv
        String weightString = "";
        String[] records = {};
        try {
            CSVReader reader = new CSVReader(new FileReader(filePath));
            records = reader.readNext();
        } catch (IOException | CsvValidationException e) {}

        if (records[0].equals("imperial"))
            weightString = records[1] + " pounds.";
        else if (records[0].equals("metric"))
            weightString = records[1] + " kilos.";
        else
            throw new IllegalArgumentException("There is no recorded weight.");

        // Returns the output string
        return weightString;
    }

}
