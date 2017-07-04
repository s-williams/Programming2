import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Creates and writes to the log file
 */
public class Log {

    private static String logName;

    private static final Logger logger = Logger.getLogger(Log.class.getName());

    public Log() {

        try {

            //Creates a date to use with the logfile name
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            Date date = new Date();
            logName = dateFormat.format(date) + ".log";

            FileHandler fileHandler = new FileHandler(logName);

            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            Log.write("Created Log");

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String message) {
        logger.info(message);
    }

    public String getLogName() throws Exception {
        return logName;
    }
}