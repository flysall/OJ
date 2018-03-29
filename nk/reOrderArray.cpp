class Solution {
public:
    void reOrderArray(vector<int> &array) {
        int bar = -1;
        for(int i = 0; i < array.size(); i++) {
            int val = array[i];
            if(val % 2 == 1) {
                for(int j = i -1; j > bar; j--)
                    array[j+1] = array[j];
                array[++bar] = val;
            }
        }
    }
};