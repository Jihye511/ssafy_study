#include <bits/stdc++.h>

using namespace std;

int arr[100][100];

int dirs[4][2] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

int res = 1000000;
int n = -1;
int cnt = 0;
int maxcore = 0;

void solve(int t, int c, int curlen) {
	int x = t / n;
	int y = t % n;
//	if (curlen > res) return;
	if (t == n * n) {
		if (maxcore <= c) {
			if (maxcore == c) {
				res = min(res, curlen);
			}
			else {
				res = curlen;
			}
//			res = min(res, curlen);
			maxcore = c;
//			cout << "RRRRRRRRRRRRRR" << " " << res << endl;
//			
//			for (int i = 0; i< n; i++) {
//				for (int j =0;j  < n; j++) {
//					cout << arr[i][j] << " ";
//				}
//				cout << endl;
//			}
		}
		return;
	}
	if (arr[x][y] == 0 || arr[x][y] == 2) {
//		cout << t << " : " << curlen << endl;
		while(1) {
			t++;
			x = t / n;
			y = t % n;
			if (t == n * n || arr[x][y] == 1) break;
		}
	}
	if (t == n * n) {
		if (maxcore <= c) {
			if (maxcore == c) {
				res = min(res, curlen);
			}
			else {
				res = curlen;
			}
//			res = min(res, curlen);
			maxcore = c;
//			cout << "RRRRRRRRRRRRRR" << " " << res << endl;
//			
//			for (int i = 0; i< n; i++) {
//				for (int j =0;j  < n; j++) {
//					cout << arr[i][j] << " ";
//				}
//				cout << endl;
//			}
		}
		return;
	}
	
	
	if (x == 0 || y == 0 || x == n - 1 || y == n - 1) {
		solve(t + 1, c + 1, curlen);
		return;
	}
//	cout << "t" << t << " " << c << " " << curlen << endl;
	vector<array<int, 2>> temp; 
	for (auto &d : dirs) {
		int cx=  x;
		int cy = y;
		int len = 0;
		bool valid = true;
		while(1) {
			cx += d[0];
			cy += d[1];
			if (cx < 0 || cy < 0 || cx >= n || cy >= n) break;
			if (arr[cx][cy]) {
				valid = false;
				break;
			}
			
			temp.push_back({cx, cy});
			len++;
		}
//		cout << "t : " << t << "dir " << d[0] << " " << d[1] << ": " << len << endl;
		if (valid && len == 0) {
//			cout << "FUCK" << endl;
			return;
//			solve(t + 1, c + 1, curlen);
		}
		else if (valid) {
			for (auto &t : temp) {
				int x = t[0];
				int y = t[1];
				arr[x][y] = 2;
			}
			solve(t + 1, c + 1, curlen + len);
			for (auto &t : temp) {
				int x = t[0];
				int y = t[1];
				arr[x][y] = 0;
			}
		}
		temp.clear();
	}
	solve(t + 1, c, curlen);
	
}
int main() {
	int t;
	cin >> t;
	
	for (int tt= 1; tt <= t; tt++) {
		cin >> n;
		res = 1000000;
		maxcore = 0;
		cnt = 0;
		
		memset(arr, 0, sizeof arr);
		for (int i= 0; i< n; i++){ 
			for (int j = 0;j <n; j++){
				cin >> arr[i][j];
				if (arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		solve(0, 0, 0);
		
		if (res == 1000000) cout << "#" << tt << " " << 0 << endl;
		else cout << "#" << tt << " " << res << endl;
	}
}