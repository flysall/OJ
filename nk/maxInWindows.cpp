class Solution {
public:
    vector<int> maxInWindows(const vector<int>& num, unsigned int size)
    {
        vector<int> res;
        deque<int> s;    // 双端队列用来存放下标
        for(unsigned int i = 0; i < num.size(); i++) {
            while(s.size() && num[s.back()] <= num[i])
                s.pop_back();   // 循环终止时队列的首个元素对应的num最大
            if(s.size() && i-s.front()+1 > size)
                s.pop_front();
            s.push_back(i);
            if(size && i+1 >= size)
                res.push_back(num[s.front()]);
        }
        return res;
    }
};