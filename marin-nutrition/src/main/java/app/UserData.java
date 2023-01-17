package app;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class UserData {

    static File filePath = new File("src/main/resources/userData.csv");

    // This records some basic bits of user data to be used
    // in the progress report emails
    // Does not accept the empty string or strings above 100 characters long
    public void recordUserData(String name, String email) throws IOException {
        // Checks to see if name is valid
        if (name.equals(""))
            throw new IllegalArgumentException("Name not provided.");
        if (name.length() > 100)
            throw new IllegalArgumentException("Name is too valid.");

        // Checks to see if email is valid
        if (email.equals(""))
            throw new IllegalArgumentException("Email not provided.");
        if (email.length() > 100)
            throw new IllegalArgumentException("Email is too valid.");

        try {
            FileWriter outputFile = new FileWriter(filePath);
            CSVWriter writer = new CSVWriter(outputFile);

            String[] data = {name, email};
            writer.writeNext(data);

            writer.close();

        } catch (IOException e) {
            System.out.println("There was an issue with recording your info.");
        }
    }

    public String returnName() {
        String[] records = {};
        try {
            CSVReader reader = new CSVReader(new FileReader(filePath));
            records = reader.readNext();
        } catch (IOException | CsvValidationException e) {}

        if (records.length != 2)
            throw new IllegalArgumentException("There is no recorded name.");

        // Returns the output string
        return records[0];
    }

    public String returnEmail() {
        String[] records = {};
        try {
            CSVReader reader = new CSVReader(new FileReader(filePath));
            records = reader.readNext();
        } catch (IOException | CsvValidationException e) {}

        if (records.length != 2)
            throw new IllegalArgumentException("There is no recorded email.");

        // Returns the output string
        return records[1];
    }
}
