#include <bits/stdc++.h>
using namespace std;
int arr[500][500] = {0};
int large = 0;
int n, m;
bool test(int a, int b) {
  int u = 0; int d = 0; int l = 0; int r = 0;
  for (int i = a+1; i < n; i++) {
    if (arr[i][b]) r++;
    else break;
  }
  for (int i = a-1; i >= 0; i--) {
    if (arr[i][b]) l++;
    else break;
  }
  for (int j = b+1; j < m; j++) {
    if (arr[a][j]) u++;
    else break;
  }
  for (int j = b-1; j >= 0; j--) {
    if (arr[a][j]) d++;
    else break;
  }
  // cout << u << " " << d << " " << l << " " << r << endl;
  if (u*d*l*r == 0) return false;
  return u+d+l+r == large-1;
}
int main() {
  // freopen("input.txt", "r", stdin);
  cin >> n >> m;
  vector<pair<int, int>> suc;
  for (int i = 0; i < n; i++) {
    string str; cin >> str;
    for (int j = 0; j < m; j++) {
      if (str[j]=='*') {
        large++;
        suc.push_back({i, j});
        arr[i][j] = 1;
      }
    }
  }
  // cout << endl;
  // for (int i = 0; i < n; i++) {
  //   for (int j = 0; j< m; j++) {
  //     cout << arr[i][j] << " ";
  //   }
  //   cout << endl;
  // }
  for (auto ele: suc) {
    if (test(ele.first, ele.second)) goto done;
  }
  // cout << test(2, 2) << endl;
  if (false) {
    done:
    cout <<"YES";
  }
  else {
    cout << "NO";
  }
}
