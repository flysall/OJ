import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for(int i = 0; i < n; i++)
            input[i] = sc.nextInt();
        int curP = n;
        Set<Integer> set = new HashSet<>();
        for(int i = n-1; i >= 0; i--) {
            if(set.add(input[i]))
                input[--curP] = input[i];
        }
        System.out.print(input[curP++]);
        for(; curP < n; )
            System.out.print(" " + input[curP++]);
        System.out.println();
    }
}


