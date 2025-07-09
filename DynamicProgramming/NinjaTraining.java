import java.util.*;

public class NinjaTraining{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            arr[i][2] = in.nextInt();
        }

        System.out.println(function(n - 1, 3, arr));
    }

    private static int function(int day, int last, int[][] arr){

        if (day == 0){
            int max = 0;
            for (int i = 0; i < arr.length; i++){
                if (i != last){
                    max = Math.max(max, arr[day][i]);
                }
            }

            return max;
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++){
            if (i != last){
                int merit = arr[day][i] + function(day - 1, last, arr);
                max = Math.max(max, merit);
            }
        }

        return max;
    }
}