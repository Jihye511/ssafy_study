#include <bits/stdc++.h>

using namespace std;

int main() {
    int t;
    cin >> t;

    for (int tt = 1; tt <= t; tt++) {
        int n;
        cin >>n;

        int s[10] = {};
        int res = 0;
        int cnt = 0;
        while(1){ 
            cnt++;
            int cur = cnt * n;
            res += n;

            int temp = cur;
            while(1) {
                int target = temp % 10;
                s[target] = 1;
                if (temp < 10) break;
                temp /= 10;
                
            }
            bool valid = true;

            for (int i = 0;i < 10; i++) {
                if (s[i] == 0) valid = false;
            }
            if (valid) break;
        }

        cout << "#" << tt << " " << res << endl;
    }
}