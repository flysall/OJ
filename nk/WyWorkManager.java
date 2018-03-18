import java.util.*;
public class Main {
    private static int cases = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ables = new String[n];
        for(int i = 0; i < n; i++) 
            ables[i] = sc.next();
        backtracing(ables, 0, new HashSet<Integer>());
        System.out.println(cases);
    }
    public static void backtracing(String[] ables, int index, Set<Integer> set) {
        if(index  >= ables.length) {
            cases++;
            return;
        }
        String able = ables[index];
        for(int i = 0; i < able.length(); i++) {
            int work = able.charAt(i) - '0';
            if(!set.contains(work)) {
                set.add(work);
                backtracing(ables, index + 1, set);
                set.remove(work);
            }
        }
    }
}
