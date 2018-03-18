import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            String [] str = new String[n];
            for(int i = 0; i < n; i++)
                str[i] = sc.next();
            int count = 0;
            for(int j = 0; j < n; j++) {
                int c = 1;
                for(int i = 0; i < n - 1; i++) {
                    if(str[i].charAt(j) == str[i+1].charAt(j)) {
                        c++;
                        count = Math.max(c, count);
                    } else {
                        c = 1;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
