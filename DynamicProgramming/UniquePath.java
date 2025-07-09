import java.util.*;

public class UniquePath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = 1;
                } else {
                     int up = i > 0 ? dp[i - 1][j] : 0;
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }
        System.out.println(dp[row - 1][col - 1]);

        // int ans = function(row, col);
    }

    static int function(int row, int col){
        if (row == 1 && col == 1){
            return 1;
        }
        
        int up = 0;
        if (row > 1){
            up = function(row - 1, col);
        }

        int left = 0;
        if (col > 1){
            left = function(row, col - 1);
        }

        return up + left;
    }
}
