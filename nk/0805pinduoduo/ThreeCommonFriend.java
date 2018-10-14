import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int user = sc.nextInt();
        String[] inputs = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            inputs[i] = sc.nextLine();
        }
        Set<Integer> userFriends = new HashSet<>();
        String userInput = inputs[user];
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (c != ' ') {
                userFriends.add(Character.digit(c, 10));
            }
        }
        int mostMatchCount = 0;
        TreeSet<Integer> mostMatchStrangers = new TreeSet<>();
        for (int i = 0; i < inputs.length; i++) {
            if (i == user || userFriends.contains(i)) {
                continue;
            }
            int matchCount = 0;
            String input = inputs[i];
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if(c != ' ' && userFriends.contains(Character.digit(c, 10))) {
                    matchCount++;
                }
            }
            if (matchCount == mostMatchCount) {
                mostMatchStrangers.add(i);
            } else if (matchCount > mostMatchCount) {
                mostMatchStrangers.clear();
                mostMatchStrangers.add(i);
                mostMatchCount = matchCount;
            }
        }
        if (mostMatchStrangers.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(mostMatchStrangers.first());
        }
    }
}
