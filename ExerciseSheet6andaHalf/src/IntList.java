import java.util.ArrayList;

/**
 * List of integers
 */
public class IntList {
    private ArrayList<Integer> arrayList;

    public IntList() {
        arrayList = new ArrayList<Integer>();
    }

    public synchronized void add(int i) {
        arrayList.add(i);
    }

    public synchronized Integer get() {
        int index = arrayList.size() - 1;
        Integer returnInt = arrayList.get(index);
        arrayList.remove(index);
        return returnInt;
    }

    public synchronized boolean isEmpty() {
        return arrayList.isEmpty();
    }
}
