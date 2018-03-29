class Solution {
public:
    int minNumberInRotateArray(vector<int> rotateArray) {
        if(rotateArray.size() == 0) return 0;
        int low  = 0, high = rotateArray.size()-1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(rotateArray[mid] > rotateArray[high]) {
                low =  mid + 1;
            } else if(rotateArray[mid] == rotateArray[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }
        return rotateArray[low];
    }
};