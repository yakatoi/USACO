#include <bits/stdc++.h>
using namespace std;
bool compy(pair<int, int> a, pair<int, int> b) {
  return a.second < b.second;
}

int main() {
  freopen("input.txt", "r", stdin);
  // freopen("reduce.in", "r", stdin);
  // freopen("reduce.out", "w", stdout);
  int n; cin >> n;
  pair<int, int> arr[n];
  for (int i = 0; i < n; i++) {
    int a, b; cin >> a>> b;
    arr[i] = {a, b};
  }
  set<int> ls;
  set<int> rs;
  set<int> us;
  set<int> ds;
  sort(arr, arr+n);
  ls.insert(arr[0].first); ls.insert(arr[1].first); ls.insert(arr[2].first); ls.insert(arr[3].first);
  rs.insert(arr[n-1].first); rs.insert(arr[n-2].first); rs.insert(arr[n-3].first); rs.insert(arr[n-4].first);
  sort(arr, arr+n, compy);
  ds.insert(arr[0].second); ds.insert(arr[1].second); ds.insert(arr[2].second); ds.insert(arr[3].second);
  us.insert(arr[n-1].second); us.insert(arr[n-2].second); us.insert(arr[n-3].second); us.insert(arr[n-4].second);
  int area = INT_MAX;
  for (int l : ls) {
    for (int r: rs) {
      for (int d: ds) {
        for (int u : us) {
          if (l > r || d> u) continue;
          int count = 0;
          for (auto ele : arr) {
            if (ele.first < l || ele.first > r || ele.second < d || ele.second > u) count++;
          }
          if (count<= 3) {
            area = min(area, (r-l)*(u-d));
          }
        }
      }
    }
  }
  cout << area;
}
