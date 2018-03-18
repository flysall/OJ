import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = Integer.parseInt("" + str.charAt(0));
        char operator = ' ';
        for(int i = 1; i < str.length(); i++) {
            if(i % 2 != 0)
                operator = str.charAt(i);
            else {
                int val = Integer.parseInt("" + str.charAt(i));
                switch(operator) {
                    case '+':
                        result += val;
                        break;
                    case '-':
                        result -= val;
                        break;
                    case '*':
                        result *= val;
                        break;
                }
            }
        }
        System.out.println(result);
    }
}
