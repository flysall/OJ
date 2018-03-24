class Solution {
public:
    int GetUglyNumber_Solution(int index) {
        if(index < 1) return 0;
        int i2 = 0, i3 = 0, i5 = 0, cnt = 1;
        vector<int> dp(index);
        dp[0] = 1;
        while(cnt < index) {
            int n2 = dp[i2] * 2, n3 = dp[i3] * 3, n5 = dp[i5] * 5;
            int tmp = min(n2, min(n3, n5));
            dp[cnt++] = tmp;
            if(tmp == n2) 
                i2++;
            if(tmp == n3)
                i3++;
            if(tmp == n5)
                i5++;
        }
        return dp[index-1];
    }
};