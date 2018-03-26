class Solution {
public:
    vector<int> multiply(const vector<int>& A) {
        int len = A.size();
        vector<int> B(len);
        if(len != 0) {
            B[0] = 1;
            for(int i = 1; i < len; i++)
                B[i] = B[i-1] * A[i-1];
            int temp = 1;
            for(int j = len - 2; j >= 0; j--) {
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }
};