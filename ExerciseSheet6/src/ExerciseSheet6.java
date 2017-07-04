import java.util.HashSet;
import java.util.Vector;

public class ExerciseSheet6 {

    public static void main(String[] args) {
        (new ExerciseSheet6()).QuestionOne();
    }

    private void QuestionOne() {
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total = total + (new SynchRollDie()).getVal();
        }
        System.out.println("Total of 5 dice is " + total);
    }
}

