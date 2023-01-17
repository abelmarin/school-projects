package app;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class ProgressReport {

    private static void sendEmail(String to, String from, String contents) {
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set header field
            message.setSubject("This is your health progress report!");

            // Set actual message
            message.setText(contents);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }


    private static String formatWorkout(String[] workout) {
        String formattedWorkout = "";
        if (workout[1].equals("reps")) {
            formattedWorkout = workout[2] + " sets of " + workout[0] +
                    ", " + workout[3] + " reps each\n";
        } else if (workout[1].equals("time") && workout[2].equals("1")) {
            formattedWorkout = "A set of " + workout[0] +
                    ", for" + workout[3] + " minutes\n";
        } else if (workout[1].equals("time") && !workout[2].equals("1")) {
            formattedWorkout = workout[2] + " sets of " + workout[0] +
                    ", " + workout[3] + " minutes each\n";
        }

        return formattedWorkout;
    }

    public static String sendReportOverEmail() throws IOException, CsvException, MessagingException {
        // Retrieves the contents of userData.csv
        UserData info = new UserData();
        String userName = info.returnName();
        String userEmail = info.returnEmail();

        // Retrieves the contents of measurements.csv
        TrackWeight weightInfo = new TrackWeight();
        String userWeight = weightInfo.returnWeight();

        // Retrieves the contents of workoutsTracked.csv
        TrackWorkout workoutInfo = new TrackWorkout();
        List<String[]> userWorkouts = workoutInfo.returnTrackedWorkouts();

        // Created a string out of the previously retrieved
        // data in order to send over email
        String outputString = "Hi " + userName + "!\n"
                + "Your new weight is " + userWeight + "\n"
                + "You have performed these exercises:\n";

        for (int i = 0; i < userWorkouts.size(); i++) {
            outputString = outputString + formatWorkout(userWorkouts.get(i));
        }
//
//        // Sends the emailf
//        SendEmail(userEmail,from,outputString);

        return outputString;
    }
}
