import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tx = new int[n];
        int[] ty = new int[n];
        for(int i = 0; i < n; i++)
            tx[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            ty[i] = sc.nextInt();
        int gx = sc.nextInt();
        int gy = sc.nextInt();
        int wt = sc.nextInt();
        int dt = sc.nextInt();
        int walkTime = (Math.abs(gx) + Math.abs(gy)) * wt;
        int driveTime = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            driveTime = Math.min(driveTime, (Math.abs(ty[i]) + Math.abs(tx[i])) * wt +
                 (Math.abs(ty[i] - gy) + Math.abs(tx[i] - gx)) * dt);
        }
        System.out.println(Math.min(walkTime, driveTime));
    }
}
