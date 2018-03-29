class Solution {
public:
    int jumpFloorII(int number) {
        if(number <= 0)
            return -1;
        int b = 1;
        for(int i = 1; i < number; i++) 
            b *= 2;
        return b;
    }
};