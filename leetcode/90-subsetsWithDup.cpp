class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> res;
        if(nums.size() == 0) return res;
        vector<int> item;
        sort(nums.begin(), nums.end());
        backtrack(res, item, 0, nums);
        return res;
    }
    void backtrack(vector<vector<int>>& res, vector<int>& item, int start, vector<int>& nums) {
        res.push_back(vector<int>(item));
        for(int i = start; i < nums.size(); i++) {
            if(i > start && nums[i] == nums[i-1])
                continue;
            item.push_back(nums[i]);
            backtrack(res, item, i+1, nums);
            item.pop_back();
        }
    }
};
