import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Vector;

import static java.lang.Thread.sleep;

public class ExerciseSheet5 {

    //Main
    public static void  main(String[] args) {
        //QuestionOne
        Thread QuestionOneThread = new Thread(new QuestioneOne());
        QuestionOneThread.start();

        try {
            QuestionOneThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //QuestionTwo
        RollDie rollDie = new RollDie();
        Thread RollDieThread = new Thread(rollDie);
        RollDieThread.start();

        try {
            RollDieThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //QuestionThree
        QuestionThree questionThree = new QuestionThree();
    }
}

class QuestioneOne implements Runnable {
    public void run() {
        System.out.println("##########\nQuestion One\n##########");
        Thread questionOneThread1 = new QuestionOneThread1();
        Thread questionOneThread2 = new QuestionOneThread2();
        Thread questionOneThread3 = new QuestionOneThread3();

        try {
            questionOneThread1.start();
            questionOneThread2.start();
            questionOneThread3.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    class QuestionOneThread1 extends Thread {
        public void run() {
            try {
                sleep(30);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("" + 1);
        }
    }

    class QuestionOneThread2 extends Thread {
        public void run() {
            try {
                sleep(20);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("" + 2);
        }
    }

    class QuestionOneThread3 extends Thread {
        public void run() {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("" + 3);
        }
    }
}

class QuestionThree {



    public QuestionThree() {
        System.out.println("##########\nQuestion Three\n##########");
        Vector<Integer> vector = new Vector<Integer>();

        for (int i = 1; i <101; i++) {
            vector.add(i);
        }

        check100VectorPrime(vector);
    }



    public void check100VectorPrime(Vector<Integer> inputVector) {

        HashSet<QuestionThreeThread> questionThreeThreads = new HashSet<QuestionThreeThread>();

        for (int i = 0; i < 10; i++) {
            Vector<Integer> vector = getPartOfVector(inputVector, i*10, (i * 10) + 10);
            questionThreeThreads.add(new QuestionThreeThread(vector));
        }

        for (QuestionThreeThread questionThreeThread : questionThreeThreads) {
            questionThreeThread.start();
        }
    }

    private Vector<Integer> getPartOfVector(Vector<Integer> inputVector, int start, int end) {
        Vector<Integer> outputVector = new Vector<Integer>();

        for(int i = start; i < end; i++) {
            outputVector.add(inputVector.get(i));
        }

        return outputVector;
    }

    class QuestionThreeThread extends Thread {

        Vector<Integer> vector;

            public QuestionThreeThread(Vector<Integer> vector) {
            this.vector = vector;
        }

        public void run() {
            for(Integer integer : vector) {
                if(AePrime.checkPrime(integer))
                    System.out.println(integer + " is prime");
                else
                    System.out.println(integer + " is not prime");
            }
        }
    }

}