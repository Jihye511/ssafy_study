#include <bits/stdc++.h>

using namespace std;

vector<int> cipher;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    int t = 10;

    for (int tt=  1; tt <= t; tt++ ){
         int n;
        cin >> n;
        cipher.clear();

        for (int i = 0; i< n; i++) {
            int in;
            cin >> in;
            cipher.emplace_back(in);
        }

        int m;
        cin>>m;

        while(m--) {
            char cc;
            int a, b, c;
            cin >> cc;

            if (cc == 'I') {
                cin >> a >> b;
                vector<int> temp;
                for (int i = 0; i < b; i++) {
                    int in;
                    cin >> in;
                    temp.emplace_back(in);
                }
                cipher.insert(cipher.begin() + a, temp.begin(), temp.end());
            }
            if (cc == 'D') {
                cin >> a >> b;
                cipher.erase(cipher.begin() + a, cipher.begin() + a + b);
                
            }
            if (cc == 'A') {
                cin >> a;
                for (int i= 0; i< a; i++) {
                    int in;
                    cin >> in;
                    cipher.emplace_back(in);
                }
            }
        }
        cout << "#" << tt << " ";
        for (int i =0 ; i< 10; i++) {
            cout << cipher[i] << " ";
        }
        cout << endl;
    }
   
}