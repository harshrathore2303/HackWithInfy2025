import java.util.Arrays;

public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[7][4];
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        for (int[] i : dp){
            Arrays.fill(i, -1);
        }
        System.out.println(countPath(m - 1, n - 1, dp, obstacleGrid));
    }

    static int countPath(int d, int r, int[][] dp, int[][] arr){
        if (d == 0 && r == 0 && arr[d][r] != 1){
            return 1;
        }

        if (dp[d][r] != -1){
            return dp[d][r];
        }
        int down = 0;
        int right = 0;
        if (d > 0 && arr[d][r] != 1){
            down = countPath(d-1, r, dp, arr);
        }

        if (r > 0 && arr[d][r] != 1){
            right = countPath(d, r-1, dp, arr);
        }

        dp[d][r] = down + right;
        return dp[d][r];
    }
}
