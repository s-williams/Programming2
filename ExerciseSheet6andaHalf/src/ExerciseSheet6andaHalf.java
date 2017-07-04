import java.util.HashSet;
import java.util.Vector;

/**
 * Exercise Sheet 6 Question 2
 */
public class ExerciseSheet6andaHalf {
    public static void main(String[] args) {
        IntList intList = new IntList();
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            intList.add(i);
        }

        QuestionTwo questionTwo = new QuestionTwo(intList, Integer.parseInt(args[1]));
    }
}

class QuestionTwo {

    IntList intList;
    int threads;

    QuestionTwo(IntList intList, int threads) {
        System.out.println("############\nQuestion Two\n############");
        this.intList = intList;
        this.threads = threads;

        checkIntListPrime();
    }

    private void checkIntListPrime() {

        HashSet<QuestionTwoThread> questionTwoThreads = new HashSet<QuestionTwoThread>();

        for (int i = 0; i < threads; i++) {
            questionTwoThreads.add(new QuestionTwoThread());
        }

        for (QuestionTwoThread questionTwoThread : questionTwoThreads) {
            questionTwoThread.start();
        }
    }

    private class QuestionTwoThread extends Thread {

        public void run() {
            while (!intList.isEmpty()) {
                int processedInt = intList.get();
                if (checkPrime(processedInt)) {
                    System.out.println(processedInt + " is prime");
                } else System.out.println(processedInt + " is not prime");
            }
        }
    }

    //Returns true if number is prime
    private static boolean checkPrime(int n) {
        int primes55[] = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,
                53,59,61,67,71,73,79,83,89,97,101,103,107,
                109,113,127,131,137,139,149,151,157,163,
                167,173,179, 181,191,193,197,199,211,223,
                227,229,233,239,241,251,257};

        for(int i=0;i < 55;i++) {
            if (n % primes55[i] == 0) {
                if (n == primes55[i]) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        int maxtest = n/16;

        for(int i=259; i < maxtest; i+=2)
            if (n % i == 0)
                return false;

        return true;
    }

}
