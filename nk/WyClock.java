import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int hh = 0, mm = 0;
        int[] a = new int[N];
        for(int i = 0; i < N; i++) {
            hh = sc.nextInt();
            mm = sc.nextInt();
            a[i] = (hh * 60) + mm;
        }
        int timeToClass = sc.nextInt();
        int sHH = sc.nextInt();
        int sMM = sc.nextInt();
        int targetTime = (sHH * 60) + sMM;
        int min = 0;
        for(int i = 0; i < a.length; i++) {
            if(targetTime - (timeToClass + a[i]) < 0)
                continue;
            else {
                if(a[i] > a[min])
                    min = i;
            }
        }
        System.out.println(a[min] / 60 + " " + a[min] % 60);
    }
}

