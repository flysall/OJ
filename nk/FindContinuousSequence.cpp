class Solution {
public:
    vector<vector<int> > FindContinuousSequence(int sum) {
        vector<vector<int>> allRes;
        int phigh = 2, plow = 1;
        while(phigh > plow) {
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            if(cur < sum)
                phigh++;
            if(cur == sum) {
                vector<int> res;
                for(int i = plow; i <= phigh; i++)
                    res.push_back(i);
                allRes.push_back(res);
                plow++;
            }
            if(cur > sum)
                plow++;
        }
        return allRes;
    }
};