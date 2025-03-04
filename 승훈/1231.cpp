#include <bits/stdc++.h>

using namespace std;

char tree[100000];

void traverse(int n, int v) {
    if (v > n) return;
    traverse(n, v * 2);
    cout << tree[v];
    traverse(n, v * 2 + 1);
}
int main() {
    int t =  10;
    for (int tt = 1; tt <= t; tt++) {
        int n;
        cin >> n;
        getchar();

        memset(tree, 0, sizeof tree);

        for (int i = 0; i < n; i++) {
            string s;
            getline(cin, s);

            vector<string> v;
            string temp = "";
            for (int i =0 ; i< s.length(); i++) {
                // cout << s[i];
                
                if (s[i] == ' ') {
                    v.push_back(temp);
                    temp = "";
                    continue;
                }
                temp.push_back(s[i]);
            }
            if (temp.length() != 0) {
                v.push_back(temp);
            }
            
            // cout << endl;
            int a = stoi(v[0]);
            char c = v[1][0];
            // cout << a << c << endl;
            tree[stoi(v[0])] = v[1][0];
            
        }

        // for (int i = 1; i <= n; i++) {
        //     cout << tree[i] << " ";
        // }
        // cout << endl;

        cout << "#" << tt << " ";
        traverse(n, 1);
        cout << endl;


    }
}