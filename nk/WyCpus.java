import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt(), sum = 0;
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt() >> 10;
                sum += arr[i];
            }
            // dp[j]
            int[] dp = new int[sum / 2 + 1];
            for(int i = 0; i < n; i++) {
                for(int j = sum / 2; j >= arr[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - arr[i]] + arr[i]);
                }
            }
            System.out.println(Math.max(dp[sum / 2], sum - dp[sum / 2]) << 10);
        }
    }
}
