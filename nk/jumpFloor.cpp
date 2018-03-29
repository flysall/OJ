class Solution {
public:
    int jumpFloor(int number) {
        int a = 1, b = 1;
        for(int i = 1; i < number; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
};