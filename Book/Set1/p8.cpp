#include <bits/stdc++.h>
using namespace std;
int a[50][50] = {0};
int b[50][50]= {0};
bool checkE(int n, int m) {
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (a[i][j]!=b[i][j]) return false;
    }
  }
  return true;
}
int main() {
  // freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  int n, m; cin >> n >> m;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> a[i][j];
    }
  }
  vector<pair<int, int>> oper;
  for (int i = 0; i < n-1; i++) {
    for (int j = 0; j < m-1; j++) {
      if ((a[i][j] || a[i][j+1] || a[i+1][j] || a[i+1][j+1]) && (a[i][j]*a[i+1][j+1]*a[i+1][j]*a[i][j+1])) {
        oper.push_back({i+1, j+1});
        b[i][j] = b[i][j+1] = b[i+1][j] = b[i+1][j+1] = 1;
      }
    }
  }
  if (!checkE(n, m)) {
    cout << -1 << endl;
  }
  else {
    cout << oper.size() << endl;
    for (auto ele: oper) {
      cout << ele.first << " " << ele.second << endl;
    }
  }
}
