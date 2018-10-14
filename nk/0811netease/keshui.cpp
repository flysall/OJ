#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, k;
    cin >> n, k;
    vector<int> a(n), t(n);
    for (int i = 0; i < n; i++) 
        cin >> a[i];
    int now = 0;
    for (int i = 0; i < n; i++) 
        cin >> t[i], now += t[i] * a[i];
    int res = now;
    for (int i = 0; i < n; ) {
        now += (!t[i]) * a[i];
        if (++i >= k) {
            res = max(res, now);
            now -= (!t[i-k]) * a[i-k];
        }
    }
    cout << res << endl;
    return 0;
}
