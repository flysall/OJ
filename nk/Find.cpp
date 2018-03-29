class Solution {
public:
    bool Find(int target, vector<vector<int>> array) {
        int len = array.size()-1;
        int i = 0;
        while((len >= 0) && (i < array[0].size())) {
            if(target < array[len][i])
                len--;
            else if(target > array[len][i]) 
                i++;
            else
                return true;
        }
        return false;
    }
};