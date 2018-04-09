class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> res;
        if(k <= 0 || n <= 0) return res;
        vector<int> item;
        backtrack(res, item, k, n, 1, 0);
        return res;
    }
    void backtrack(vector<vector<int>>& res, vector<int>& item, int k, int n, int start, int sum) {
        if(k == 0) {
            if(sum == n) 
                res.push_back(item);
            else
                return;
        } else {
            for(int i = start; i <= 9; i++) {
                item.push_back(i);
                sum += i;
                backtrack(res, item, k-1, n, i+1, sum);
                sum -= i;
                item.pop_back();
            }
        }
    }
};
