#include <iostream>

using namespace std;

int main()
{
    string s;
    while(cin >> s) {
        int len = s.size(), bar = -1;
        for (int i = 0; i < len; i++) {
            char tmp = s[i];
            if (tmp <= 'z' && tmp >= 'a') {
                for (int j = i - 1; j > bar; j--) {
                    s[j + 1] = s[j];
                }
                s[++bar] = tmp;
            }
        }
        cout << s << endl;
    }
    return 0;
}


