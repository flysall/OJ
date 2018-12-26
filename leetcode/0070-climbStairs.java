class Solution {
    public int climbStairs(int n) {
        int pre = 1, sum = 1, i = 1;
        while (i < n) {
            int tmpSum = pre + sum;
            pre = sum;
            sum = tmpSum;
            ++i;
        }
        return sum;
    }
}
