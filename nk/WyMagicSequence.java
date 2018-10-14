import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(r - l - f(r) + f(l-1));
        }
    }
    private static int f(int val) {
        return (val + 2) / 3;
    }
}

