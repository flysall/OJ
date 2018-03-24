class Solution {
public:
    int GetNumberOfK(vector<int> data ,int k) {
        int len = data.size();
        if(len == 0) return 0;
        int firstK = getFirstK(data, k, 0, len-1);
        int lastK = getLastK(data, k, 0, len-1);
        if(firstK != -1 && lastK != -1)
            return lastK - firstK + 1;
        return 0;
    }
    int getFirstK(vector<int> data, int k, int start, int end) {
        if(start > end)
            return -1;
        int mid = (start + end) >> 1;
        if(k < data[mid]) {
            return getFirstK(data, k, start, mid-1);
        } else if(k > data[mid]) {
            return getFirstK(data, k, mid+1, end);
        } else if(mid-1 >= 0 && data[mid-1] == k) {
            return getFirstK(data, k, start, mid-1);
        } else {
            return mid;
        }
    }
    
    int getLastK(vector<int> data, int k, int start, int end) {
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(k < data[mid]) {
                end = mid - 1;
            } else if(k > data[mid]) {
                start = mid + 1;
            } else if(mid+1 < data.size() && data[mid+1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
};
