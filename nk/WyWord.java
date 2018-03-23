import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] rememberWords = new String[n];
        Map<String, Integer> map = new HashMap<>();
        int score = 0;
        for(int i = 0; i < n; i++)
            rememberWords[i] = sc.next();
        for(int i = 0; i < m; i++) {
            String word = sc.next();
            map.put(word, 0);
        }        
        for(String word : rememberWords) {
            Integer query = map.get(word);
            if(query != null && query == 0) {
                score += word.length() * word.length();
                map.put(word, 1);
            } else {
                continue;
            }
        }
        System.out.println(score);
    }
}
