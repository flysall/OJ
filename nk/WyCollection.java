import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        Set<Float> set = new HashSet<>();
        for(int p = w; p <= x; p++) {
            for(int q = y; q <= z; q++) {
                float val = (float) p / (float) q;
                set.add(val);
            }
        }
        System.out.println(set.size());
    }
}
