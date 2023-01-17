package app;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class trackWorkoutTest {

    // These are tests for the trackWorkout function
    @ParameterizedTest
    @DisplayName("Test successfully write several workouts to workoutsTracked.csv")
    @CsvFileSource(resources = "/workoutTestSuccess.csv")
    void testSuccessfulCSVFileWriting(String name, String workoutType, int sets, int repsOrTimed, int expected) throws IOException, CsvException {
        TrackWorkout newWorkout = new TrackWorkout();
        newWorkout.trackWorkout(name, workoutType, sets, repsOrTimed);

        CSVReader reader = new CSVReader(new FileReader(TrackWorkout.trackedWorkoutsFile));
        List<String[]> allRows = reader.readAll();

        List<String[]> mockArray = new ArrayList<String[]>();
        String[] expected1 = {"Pushups","reps","5","10"};
        String[] expected2 = {"Planks","time","3","60"};
        String[] expected3 = {"Bench Press","reps","4","10"};

        if (expected == 1) mockArray.add(expected1);
        else if (expected == 2) mockArray.add(expected2);
        else if (expected == 3) mockArray.add(expected3);

        Object[] newMockArray = mockArray.toArray();
        Object[] newAllRows = allRows.toArray();

        new FileWriter(TrackWorkout.trackedWorkoutsFile, false).close();
        assertArrayEquals(newMockArray, newAllRows);
    }

    @ParameterizedTest
    @DisplayName("Test successfully write several workouts to workoutsTracked.csv")
    @CsvFileSource(resources = "/workoutTestFail.csv")
    void testFailCSVFileWriting(String name, String workoutType, int sets, int repsOrTimed) throws IOException {
        TrackWorkout newWorkout = new TrackWorkout();
        assertThrows(IllegalArgumentException.class, () -> newWorkout.trackWorkout(name,workoutType,sets,repsOrTimed));
    }

    // Tests for returnTrackedWorkouts
    @Test
    @DisplayName("Test successfully return multiple workouts")
    void testSuccessfulReturnOfWorkouts() throws IOException, CsvException {
        TrackWorkout newWorkout = new TrackWorkout();
        newWorkout.trackWorkout("Pushups","reps",5,10);
        newWorkout.trackWorkout("Planks","time",3,60);
        newWorkout.trackWorkout("Bench Press","reps",4,10);

        String[] expected1 = {"Pushups","reps","5","10"};
        String[] expected2 = {"Planks","time","3","60"};
        String[] expected3 = {"Bench Press","reps","4","10"};

        List<String[]> mockArray = new ArrayList<String[]>();
        mockArray.add(expected1);
        mockArray.add(expected2);
        mockArray.add(expected3);

        List<String[]> allRows = newWorkout.returnTrackedWorkouts();

        Object[] newMockArray = mockArray.toArray();
        Object[] newAllRows = allRows.toArray();

        new FileWriter(TrackWorkout.trackedWorkoutsFile, false).close();
        assertArrayEquals(newMockArray, newAllRows);

    }

    @Test
    @DisplayName("Test successfully return multiple workouts")
    void testUnsuccessfulReturnOfWorkouts() throws IOException, CsvException {
        TrackWorkout test = new TrackWorkout();
        assertThrows(IllegalArgumentException.class, () -> test.returnTrackedWorkouts());

    }

}
