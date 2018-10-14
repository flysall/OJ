import java.util.*;

public class Main {
    static int caseNum = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++)
            v[i] = sc.nextInt();
        Arrays.sort(v);
        backtrack(w, v, 0, 0);
        System.out.println(caseNum);
    }

    private static void backtrack(int w, int[] v, int cur, int start) {
        for (int i = start; i < v.length; i++) {
            cur += v[i];
            if(cur > w)
                break;
            else
                caseNum++;
            backtrack(w, v, cur, i + 1);
            cur -= v[i];
        }
    }
}

