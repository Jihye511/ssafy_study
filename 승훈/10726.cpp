#include <bits/stdc++.h>

using namespace std;

int main() {
    int t;
    cin >> t;

    for (int tt = 1; tt <= t; tt++) {
        int n, m;
        cin >> n >> m;

        int target = 1 << n;
        if (m % target == target - 1) cout << "#" << tt << " ON" << endl;
        else cout << "#" << tt << " OFF" << endl;
    }
}