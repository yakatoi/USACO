#include <bits/stdc++.h>

using namespace std;


int main() {
  // freopen("input.txt", "r", stdin);
  freopen("cowqueue.in", "r", stdin);
  freopen("cowqueue.out", "w", stdout);
  int n; cin >> n;
  vector<pair<int, int>> vec;
  for (int i = 0; i < n; i++) {
    int a, b; cin >> a >> b;
    vec.push_back({a, b});
  }
  sort(vec.begin(), vec.end());
  int t = 0;
  for (auto ele: vec) {
    t = max(t, ele.first);
    t+=ele.second;
  }
  cout << t;

}
