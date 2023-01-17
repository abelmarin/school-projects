package app;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class userDataTest {

    // Tests for the recordUserData function
    @Test
    @DisplayName("Test recordUserData successfully writes data to the csv")
    void testSuccessfulUserDataTracked() throws IOException {
        UserData test = new UserData();
        test.recordUserData("Abel Marin", "marinabe1416@gmail.com");

        String[] records = {};
        try {
            CSVReader reader = new CSVReader(new FileReader(UserData.filePath));
            records = reader.readNext();
        } catch (IOException | CsvValidationException e) {}

        String[] expected = {"Abel Marin", "marinabe1416@gmail.com"};
        assertArrayEquals(expected, records);
    }

    @Test
    @DisplayName("Test recordUserData fails when name is empty string")
    void testNameEmptyString() throws IOException {
        UserData test = new UserData();
        assertThrows(IllegalArgumentException.class, () -> test.recordUserData("", "marinabe1416@gmail.com"));
    }

    @Test
    @DisplayName("Test recordUserData fails when email is empty string")
    void testEmailEmptyString() throws IOException {
        UserData test = new UserData();
        assertThrows(IllegalArgumentException.class, () -> test.recordUserData("Abel Marin", ""));
    }

    @Test
    @DisplayName("Test recordUserData fails when name is above 100 characters long")
    void testNameTooLong() throws IOException {
        UserData test = new UserData();
        assertThrows(IllegalArgumentException.class, () -> test.recordUserData("Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio ",
                "marinabe1416@gmail.com"));
    }

    @Test
    @DisplayName("Test recordUserData fails when email is above 100 characters long")
    void testEmailTooLong() throws IOException {
        UserData test = new UserData();
        assertThrows(IllegalArgumentException.class, () -> test.recordUserData("Abel Marin", "Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio "));
    }

    // Tests for returnName function
    @Test
    @DisplayName("Tests returnName successfully returns the name")
    void testReturnName() throws IOException {
        UserData test = new UserData();
        test.recordUserData("Abel Marin", "marinabe1416@gmail.com");

        String expected = "Abel Marin";
        assertEquals(expected, test.returnName());
    }

    @Test
    @DisplayName("Tests returnName throws exception due to lack of name in csv")
    void testFailReturnName() throws IOException {
        FileWriter outputFile = new FileWriter(UserData.filePath);
        CSVWriter writer = new CSVWriter(outputFile);
        writer.writeNext(new String[]{""});
        writer.close();

        UserData test = new UserData();

        assertThrows(IllegalArgumentException.class, () -> test.returnName());
    }

    // Tests for returnEmail function
    @Test
    @DisplayName("Tests returnName successfully returns the name")
    void testReturnEmail() throws IOException {
        UserData test = new UserData();
        test.recordUserData("Abel Marin", "marinabe1416@gmail.com");

        String expected = "marinabe1416@gmail.com";
        assertEquals(expected, test.returnEmail());
    }

    @Test
    @DisplayName("Tests returnEmail throws exception due to lack of email in csv")
    void testFailReturnEmail() throws IOException {
        FileWriter outputFile = new FileWriter(UserData.filePath);
        CSVWriter writer = new CSVWriter(outputFile);
        writer.writeNext(new String[]{""});
        writer.close();

        UserData test = new UserData();

        assertThrows(IllegalArgumentException.class, () -> test.returnEmail());
    }
}
