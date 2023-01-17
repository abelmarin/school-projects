package app;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
//import com.sun.tools.javac.util.List;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class TrackWorkout {

    //This file tracks the actual workouts performed by the user
    static File trackedWorkoutsFile = new File("src/main/resources/workoutsTracked.csv");

    // Creates and stores a workout and whether it uses reps
    // or if it's a timed workout
    public void trackWorkout(String name, String workoutType, int numberOfSets, int repsOrTime) throws IOException {
        // Checks to see if repsOrTimed is valid..
        // Workout must be measured in either number of reps or by minutes of time.
        if (!workoutType.equals("reps") && !workoutType.equals("time")) {
            throw new IllegalArgumentException("Workout must be measured in either reps or timed.");
        }

        if (numberOfSets == 0 || repsOrTime == 0)
            throw new IllegalArgumentException("Sets or reps/time must be greater than 0.");

        // Checks to see if name is valid.
        // Cant be empty string or be longer than 100 characters
        if (name.length() == 0)
            throw new IllegalArgumentException("No name was given.");
        if (name.length() > 100)
            throw new IllegalArgumentException("Name is not a valid length.");

        try {
            FileWriter outputFile = new FileWriter(trackedWorkoutsFile, true);
            CSVWriter writer = new CSVWriter(outputFile);

            String setString = Integer.toString(numberOfSets);
            String repsOrTimeString = Integer.toString(repsOrTime);

            String[] workoutData = {name, workoutType, setString, repsOrTimeString};
            writer.writeNext(workoutData);

            writer.close();

        } catch (IOException e) {
            System.out.println("There was an issue with recording your workout.");
        }
    }

    public List<String[]> returnTrackedWorkouts() throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader(TrackWorkout.trackedWorkoutsFile));
        List<String[]> allRows = reader.readAll();

        if (allRows.size() == 0)
            throw new IllegalArgumentException("There are no recorded workouts.");

        return allRows;
    }

}
