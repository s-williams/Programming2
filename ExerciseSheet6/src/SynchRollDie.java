/**
 * Returns final value of die roll
 */
class SynchRollDie {

    private RollDie rollDie;

    SynchRollDie() {

    }

    int getVal() {
        rollDie = new RollDie();
        Thread thread = new Thread(rollDie);
        thread.start();
        try {
            thread.join();
//            Thread.sleep(rollDie.rolls*120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return rollDie.getValueShowing();
    }
}
