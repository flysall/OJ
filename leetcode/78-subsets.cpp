class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> item;
        if(nums.size() == 0) return res;
        backtrack(res, item, 0, nums);
        return res;
    }
    void backtrack(vector<vector<int>>& res, vector<int>& item, int start, vector<int>& nums) {
        if(item.size() > nums.size())
            return;
        res.push_back(vector<int>(item));
        for(int i = start; i < nums.size(); i++) {
            item.push_back(nums[i]);
            backtrack(res, item, i+1, nums);
            item.pop_back();
        }
    }
};
