import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Simulates a dice which can be rolled
 */
public class RollDie implements Runnable {

    Random random;
    int rolls;

    public void run() {
        System.out.println("##########\nQuestion Two\n##########");
        random = new Random();
        rolls = random.nextInt(10) + 10;
        rollDice();
    }

    public void rollDice() {
        int valueShowing;
        for (int i = 1; i <= rolls; i++) {
            try {
                sleep(20 + (i*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            valueShowing = random.nextInt(6) + 1;
            if (i == rolls) System.out.println("Final value: " + valueShowing);
            else System.out.println("Dice shows: " + valueShowing);
        }
    }
}
