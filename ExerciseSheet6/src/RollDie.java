import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Simulates a dice which can be rolled
 */
class RollDie implements Runnable {

    private Random random;
    int rolls;
    private int valueShowing;

    public void run() {
        random = new Random();
        rolls = random.nextInt(10) + 10;
        rollDice();
    }

    void rollDice() {
        for (int i = 1; i <= rolls; i++) {
//            try {
//                sleep(20 + (i*100));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            valueShowing = random.nextInt(6) + 1;
//            if (i == rolls) System.out.println("Final value: " + valueShowing);
//            else System.out.println("Dice shows: " + valueShowing);
        }
    }

    public int getValueShowing() {
        System.out.println("Dice shows:" + valueShowing);
        return valueShowing;
    }
}
