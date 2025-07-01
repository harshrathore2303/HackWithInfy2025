import java.util.*;

public class MaxPeopleInSingleRoom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // int[][] arr = { { 1, 3 }, { 2, 4 }, { 3, 5 }, { 0, 6 }, { 5, 7 }, { 8, 9 } };
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        // [[1,3],[2,4],[3,5],[0,6],[5,7],[8,9]]
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int ans = 0;
        int max = arr[0][1];
        for (int i = 1; i < n; i++){
            int start = arr[i][0];
            if (start >= max){
                ans++;
                max = Math.max(max, arr[i][1]);
            }
        }

        System.out.println(ans + 1);
    }
}