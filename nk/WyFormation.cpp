#include <string>
#include <iostream>
 
using namespace std;
int main() {
    string S;
    cin >> S;
    int B = 0;
    int G = 0;
    int sumB = 0;
    int sumG = 0;
    for(int i = 0; i < S.size(); i++) {
        if(S[i] == 'G') {
            G++;
            sumG += i;
        }
        else
        {
            B++;
            sumB += i;
        }
    }
    int ret1 = sumB - B * (B - 1) / 2;
    int ret2 = sumG - G * (G - 1) / 2;
    int ret = ret1 < ret2 ? ret1 : ret2;
    cout << ret;
    return 0;
}


