#include <bits/stdc++.h>

using namespace std;

int arr[2001][2001] = {};
int x = 1000;
int y = 1000;

int main() {
  int dim = 2001;
  // freopen("input.txt", "r", stdin);
  freopen("mowing.in", "r", stdin);
  freopen("mowing.out", "w", stdout);
  vector<string> vec;
  int n; cin >> n;
  for (int i = 0; i < n; i++) {
    string dir; cin >> dir;
    int times; cin >> times;
    for (int i = 0; i < times; i++) {
      vec.push_back(dir);
    }
  }
  int t = 1;
  arr[x][y] = t;
  t++;
  int mi = 100000;
  for (auto dir: vec) {
    if (dir=="N") x--;
    if (dir=="S") x++;
    if (dir=="E") y++;
    if (dir=="W") y--;
    if (arr[x][y] == 0) {
      arr[x][y] = t;
      t++;
    }
    else {
      mi = min(mi, t -arr[x][y]);
      arr[x][y] = t;
      t++;
    }
  }
  // for (int i = 0; i < dim; i++) {
  //   for (int j = 0; j < dim; j++) {
  //     if (arr[i][j] >= 10) {
  //       cout << arr[i][j] << " ";
  //     }
  //     else {
  //       cout << arr[i][j] << "  ";
  //     }
  //   }
  //   cout << endl;
  // }
  if (mi ==100000) {
    cout << -1;
  }
  else {
    cout << mi;
  }
}
