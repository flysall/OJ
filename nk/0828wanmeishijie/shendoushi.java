import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m], dp = new int[n][m];
        int min = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
            min = Math.min(dp[i][0], min);
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
            min = Math.min(dp[0][i], min);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                min = Math.min(dp[i][j], min);
            }
        }
        int res = min < 0 ? Math.abs(min) + 1 : 1;
        System.out.println(res);
    }
}
