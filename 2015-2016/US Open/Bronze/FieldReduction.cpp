#include <bits/stdc++.h>
using namespace std;
set<int> pos;
int ans = INT_MAX;
void simulate(int ind, pair<int, int> arr[], int n) {
  int l = 40001; int r = 0;
  int u = 0; int d = 40001;
  for (int i = 0; i < n; i++) {
    if (i != ind) {
      l = min(l, arr[i].first);
      r = max(r, arr[i].first);
      d = min(d, arr[i].second);
      u = max(u, arr[i].second);
    }
  }
  ans = min(ans, (r-l)*(u-d));
}
int main() {
  // freopen("input.txt", "r", stdin);
  freopen("reduce.in", "r", stdin);
  freopen("reduce.out", "w", stdout);
  int n; cin>> n;
  pair<int, int> arr[n];
  for (int i = 0; i < n; i++) {
    int a, b; cin >> a>> b;
    arr[i] = {a, b};
  }
  int minX = 40001; int minY = 40001;
  int maxX = -1; int maxY = -1;
  for (int i = 0; i < n; i++) {
    minX = min(minX, arr[i].first);
    maxX = max(maxX, arr[i].first);
    minY = min(minY, arr[i].second);
    maxY = max(maxY, arr[i].second);
  }
  for (int i = 0; i < n; i++) {
    if (arr[i].first == minX || arr[i].first == maxX || arr[i].second == minY || arr[i].second == maxY) {
      pos.insert(i);
    }
  }
  for (int ele : pos) {
    simulate(ele, arr, n);
  }
  cout << ans;

}
