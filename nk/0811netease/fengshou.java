import java.util.Scanner;

public class fengshou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] q = new int[m];
        for (int i = 0; i < m; i++) {
            q[i] = sc.nextInt();
        }
        int[] res = new int[m];
        int[] input = new int[n];
        input[0] = a[0];
        for (int i = 1; i < n; i++) {
            input[i] = input[i-1] + a[i];
        }
        for(int i = 0; i < m; i++) {
            int apple = q[i];
            int low = 0, high = input.length-1;
            if (apple <= input[low]) {
                res[i] = 1;
                continue;
            }
            while(low <= high) {
                int mid = low + ((high - low) >> 1);
                if (apple == input[mid]) {
                    res[i] = mid+1;
                    break;
                } else if (apple < input[mid]) {
                    if (mid > low && apple > input[mid-1]) {
                        res[i] = mid+1;
                        break;
                    } else {
                        high = mid-1;
                    }
                } else {
                    if (mid < high && apple < input[mid+1]) {
                        res[i] = mid+2;
                        break;
                    } else {
                        low = mid+1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(res[i]);
        }
    }
}
