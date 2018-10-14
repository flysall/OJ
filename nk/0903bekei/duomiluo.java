import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n], xOrder = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            xOrder[i] = x[i];
            int h = sc.nextInt();
            map.put(x[i], h);
        }
        Arrays.sort(x);
        Map<Integer, Integer> res = new HashMap<>();
        res.put(x[n-1], 1);
        for (int i = n-2; i >= 0; i--) {
            int h = map.get(x[i]);
            int count = 0, j = i+1;
            for ( ; j < n; j++) {
                if (x[j] == x[i] + 1 || h >= x[j] - x[i] + 1) {
                    count++;
                } else {
                    break;
                }
            }
            int curRes = count > 0 ? count + res.get(x[j-1]) : 1;
            res.put(x[i], curRes);
        }
        for (int i = 0; i < n; i++) {
            int curX = xOrder[i];
            System.out.print(res.get(curX) + " ");
        }
        System.out.println();
    }
}