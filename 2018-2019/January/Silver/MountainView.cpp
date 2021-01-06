#include <bits/stdc++.h>
using namespace std;

bool comp(pair<int, int> a, pair<int, int> b) {
  if (a.first == b.first) return a.second > b.second;
  return a.first < b.first;
}

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("mountains.in", "r", stdin);
  freopen("mountains.out", "w", stdout);
  int n; cin >> n;
  vector<pair<int, int>> vec;
  for (int i = 0; i < n; i++) {
    int a, b; cin >> a>> b;
    vec.push_back({a-b, a+b});
  }
  sort(vec.begin(), vec.end(), comp);
  // for (auto p : vec) cout << p.first << ", " << p.second << endl;
  int right = -1000000009;
  int counter = 0;
  for (auto ele : vec) {
    if (ele.second > right) {
      counter++;
      right = ele.second;
    }
  }
  cout << counter;

}
