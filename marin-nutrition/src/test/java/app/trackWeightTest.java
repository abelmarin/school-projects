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

public class trackWeightTest {

    // Unit tests for the recordWeight function
    @Test
    @DisplayName("Test recordWeight successfully writes measurements to the csv: Imperial")
    void testSuccessfulImperial() throws IOException {
        // 200 pounds
        TrackWeight test = new TrackWeight();
        test.recordWeight("imperial", 200);

        String[] records = {};
        try {
            CSVReader reader = new CSVReader(new FileReader(TrackWeight.filePath));
            records = reader.readNext();
        } catch (IOException | CsvValidationException e) {}

        String[] expected = {"imperial", "200.0"};
        assertArrayEquals(expected, records);
    }

    @Test
    @DisplayName("Test recordWeight successfully writes measurements to the csv: Metric")
    void testSuccessfulMetric() throws IOException {
        // 90 kilograms
        TrackWeight test = new TrackWeight();
        test.recordWeight("metric", 90);

        String[] records = {};
        try {
            CSVReader reader = new CSVReader(new FileReader(TrackWeight.filePath));
            records = reader.readNext();
        } catch (IOException | CsvValidationException e) {}

        String[] expected = {"metric", "90.0"};
        assertArrayEquals(expected, records);
    }

    @Test
    @DisplayName("Test recordWeight fails due to unit being wrong")
    void testUnsuccessfulDueToUnits() throws IOException {
        TrackWeight test = new TrackWeight();
        assertThrows(IllegalArgumentException.class, () -> test.recordWeight("astronomical", (float) 200.5));
    }

    @Test
    @DisplayName("Test recordWeight fails due to unit being wrong: Metric")
    void testUnsuccessfulDueToWeightBeingInvalidMetric() throws IOException {
        // Weight is too high
        TrackWeight test = new TrackWeight();
        assertThrows(IllegalArgumentException.class, () -> test.recordWeight("metric", (float) 275.1));
    }

    @Test
    @DisplayName("Test recordWeight fails due to unit being wrong: Imperial")
    void testUnsuccessfulDueToWeightBeingInvalidImperial() throws IOException {
        // Weight is too high
        TrackWeight test = new TrackWeight();
        assertThrows(IllegalArgumentException.class, () -> test.recordWeight("imperial", (float) 600.1));
    }

    @Test
    @DisplayName("Test recordWeight fails due to unit being too low: Imperial")
    void testUnsuccessfulDueToWeightBeingTooLowImperial() throws IOException {
        // Weight is too low
        TrackWeight test = new TrackWeight();
        assertThrows(IllegalArgumentException.class, () -> test.recordWeight("imperial", (float) -0.1));
    }

    @Test
    @DisplayName("Test recordWeight fails due to unit being too low: Metric")
    void testUnsuccessfulDueToWeightBeingTooLowMetric() throws IOException {
        // Weight is too low
        TrackWeight test = new TrackWeight();
        assertThrows(IllegalArgumentException.class, () -> test.recordWeight("metric", (float) -0.1));
    }

    // Tests the returnWeight function
    @Test
    @DisplayName("Test returnWeight successfully returns the weight: Imperial")
    void testSuccessfulReturnWeightImperial() throws IOException {
        TrackWeight test = new TrackWeight();
        test.recordWeight("imperial", 180);

        String expected = "180.0 pounds.";
        String actual = test.returnWeight();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test returnWeight successfully returns the weight: Metric")
    void testSuccessfulReturnWeightMetric() throws IOException {
        TrackWeight test = new TrackWeight();
        test.recordWeight("metric", 180);

        String expected = "180.0 kilos.";
        String actual = test.returnWeight();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test returnWeight unsuccessfully returns the weight")
    void testUnsuccessfulReturnWeight() throws IOException {
        FileWriter outputFile = new FileWriter(TrackWeight.filePath);
        CSVWriter writer = new CSVWriter(outputFile);
        writer.writeNext(new String[]{""});
        writer.close();

        TrackWeight test = new TrackWeight();

        assertThrows(IllegalArgumentException.class, () -> test.returnWeight());
    }
}
