import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] rights = {'N', 'E', 'S', 'W'}, lefts = {'N', 'W', 'S', 'E'};
        while(sc.hasNext()) {
            int n = sc.nextInt(), leftCount = 0;
            String turns = sc.next();
            for(char c : turns.toCharArray())
                if(c == 'L')
                    leftCount++;
            int rightCount = n - leftCount, turnCount;
            if(leftCount >= rightCount) {
                turnCount = leftCount - rightCount;
                int dir = turnCount % 4;
                System.out.println(lefts[dir]);
            } else {
                turnCount = rightCount - leftCount;
                int dir = turnCount % 4;
                System.out.println(rights[dir]);
            }
        }
    }
}

