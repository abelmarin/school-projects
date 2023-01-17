package app;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import javax.mail.MessagingException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.icegreen.greenmail.junit.GreenMailRule;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetupTest;
import org.junit.Rule;

public class progressReportTest {

    // I tried to get mocks of emails to send using greenmail but I couldn't get
    // it to work so instead I just made some more unit tests for the sendReportOverEmail function

    // These are those tests
    @Test
    @DisplayName("Tests to see if output string is correct")
    void testProgressReportOutput() throws IOException, MessagingException, CsvException {
//        GreenMailUtil.sendTextEmailTest("to@localhost.com", "from@localhost.com","some subject", "some body");

        // Creates user data
        UserData testUserData = new UserData();
        testUserData.recordUserData("Abel Marin", "to@localhost.com");

        // Sets the weight of that user
        TrackWeight testWeight = new TrackWeight();
        testWeight.recordWeight("imperial", 200);

        // Tracks a couple of workouts
        TrackWorkout newWorkout = new TrackWorkout();
        newWorkout.trackWorkout("Pushups","reps",5,10);
        newWorkout.trackWorkout("Planks","time",3,60);
        newWorkout.trackWorkout("Bench Press","reps",4,10);

        ProgressReport test = new ProgressReport();
        String outputString = ProgressReport.sendReportOverEmail();

        String expectedString = "Hi Abel Marin!\n" +
                "Your new weight is 200.0 pounds.\n" +"You have performed these exercises:\n" +
                "5 sets of Pushups, 10 reps each\n" +"3 sets of Planks, 60 minutes each\n" +
                "4 sets of Bench Press, 10 reps each\n";

        // Clears the workoutsTracked.csv file
        new FileWriter(TrackWorkout.trackedWorkoutsFile, false).close();

        assertEquals(expectedString, outputString);
    }

    @Test
    @DisplayName("Tests to see if sendReportOverEmail fails when user data isn't present")
    void testProgressReportOutputFailsUserData() throws IOException, MessagingException, CsvException {
        new FileWriter(UserData.filePath, false).close();

        // Sets the weight of that user
        TrackWeight testWeight = new TrackWeight();
        testWeight.recordWeight("imperial", 200);

        // Tracks a couple of workouts
        TrackWorkout newWorkout = new TrackWorkout();
        newWorkout.trackWorkout("Pushups","reps",5,10);
        newWorkout.trackWorkout("Planks","time",3,60);
        newWorkout.trackWorkout("Bench Press","reps",4,10);

        ProgressReport test = new ProgressReport();

        assertThrows(NullPointerException.class, () -> test.sendReportOverEmail());

        // Clears the workoutsTracked.csv file
        new FileWriter(TrackWorkout.trackedWorkoutsFile, false).close();
    }

    @Test
    @DisplayName("Tests to see if sendReportOverEmail fails when user data isn't present")
    void testProgressReportOutputFailsWeight() throws IOException, MessagingException, CsvException {
        new FileWriter(TrackWeight.filePath, false).close();

        // Creates user data
        UserData testUserData = new UserData();
        testUserData.recordUserData("Abel Marin", "to@localhost.com");

        // Tracks a couple of workouts
        TrackWorkout newWorkout = new TrackWorkout();
        newWorkout.trackWorkout("Pushups","reps",5,10);
        newWorkout.trackWorkout("Planks","time",3,60);
        newWorkout.trackWorkout("Bench Press","reps",4,10);

        ProgressReport test = new ProgressReport();

        assertThrows(NullPointerException.class, () -> test.sendReportOverEmail());

        // Clears the workoutsTracked.csv file
        new FileWriter(TrackWorkout.trackedWorkoutsFile, false).close();
    }

    @Test
    @DisplayName("Tests to see if sendReportOverEmail fails when user data isn't present")
    void testProgressReportOutputFailsWorkouts() throws IOException, MessagingException, CsvException {
        // Creates user data
        UserData testUserData = new UserData();
        testUserData.recordUserData("Abel Marin", "to@localhost.com");

        // Sets the weight of that user
        TrackWeight testWeight = new TrackWeight();
        testWeight.recordWeight("imperial", 200);

        ProgressReport test = new ProgressReport();

        assertThrows(IllegalArgumentException.class, () -> test.sendReportOverEmail());

        // Clears the workoutsTracked.csv file
        new FileWriter(TrackWorkout.trackedWorkoutsFile, false).close();
    }
}
