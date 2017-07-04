import java.util.LinkedList;
import java.util.List;

/**
 * Finds smallest element in array of integers
 */
public class MinInt {

      int[] arr = {24,52,74,9,34,23,64,34};
//      int[] arr = {24};


    //Substitute for main
    public static void run(){
        MinInt m = new MinInt();
        System.out.println("Minimum is : " + m.findMin());
    }

    public MinInt() {

    }

    //Returns the smallest integer
    private int findMin(){
        return findMinAux(0);
    }

    private int findMinAux(int index){
        if(index == arr.length-1){
            return arr[index];
        } else {
            if (arr[index] < findMinAux(index+1)){
                return arr[index];
            } else {
                return findMinAux(index +1);
            }
        }
    }
}