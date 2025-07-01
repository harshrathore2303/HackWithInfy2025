import java.util.Comparator;
import java.util.*;
// [value, weight]
public class FractionalKnapsackProblem {
    static class ItemComparator implements Comparator<int[]>{

        @Override
        public int compare(int[] a, int[] b) {
            double o1 = (1.0 * a[0]) / a[1];
            double o2 = (1.0 * b[0]) / b[1];
            return Double.compare(o1, o2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++){
            weight[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++){
            value[i] = in.nextInt();
        }
        int capacity = in.nextInt();

        int[][] resultant = new int[n][2];

        for (int i = 0; i < n; i++){
            resultant[i][0] = value[i];
            resultant[i][1] = weight[i];
        }

        Arrays.sort(resultant, new ItemComparator());
        
        int sum = 0;
        for (int i = 0; i < n; i++){
            if (resultant[i][1] <= capacity){
                capacity -= resultant[i][1];
                sum += resultant[i][0];
            } else {
                sum += ((1.0 * resultant[i][0]) / resultant[i][1]) * capacity;
                break;
            }
        }
        System.out.println(sum);
    }
}
