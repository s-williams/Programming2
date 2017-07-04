import java.io.*;
import java.util.Random;

/**
 * ExerciseSheet7
 */
public class ExerciseSheet7 {
    public static void main(String[] args) {
        try {
            (new ExerciseSheet7()).QuestionOne();
            (new ExerciseSheet7()).QuestionTwo("src", "QuestionTwoOut.txt");
            (new ExerciseSheet7()).QuestionThree();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void QuestionOne() throws IOException {

        File outputByte = new File("outputByte.txt");
        File outputChar = new File("outputChar.txt");

        FileOutputStream fileOutputStream = new FileOutputStream(outputByte);
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            fileOutputStream.write(random.nextInt(100000));
        }

        FileWriter fileWriter = new FileWriter(outputChar);

        for (int i = 0; i < 10000; i++) {
            fileWriter.write(random.nextInt(100000));
        }

        System.out.println("Bytes: " + outputByte.length() + ", Chars: " + outputChar.length());
    }

    private void QuestionTwo(String dirName, String fileName) throws IOException {
        File outputFile = new File(fileName);
        OutputStream outputStream = new FileOutputStream(fileName);
        byte[] buffer = new byte[8192];

        File dir = new File(dirName);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                InputStream in = new FileInputStream(child);
                int b = 0;
                while ((b = in.read(buffer)) >= 0) {
                    outputStream.write(buffer, 0, b);
                    outputStream.flush();
                }
            }
            outputStream.close();
        } else {
            System.out.println("Directory is not a thing");
        }
    }

    private void QuestionThree() {
        QuestionThreeGUI questionThreeGUI = new QuestionThreeGUI();
    }

    private void QuestionFour() {

    }

    private void QuestionFive() {

    }
}
