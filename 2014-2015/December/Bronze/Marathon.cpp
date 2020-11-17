#include <bits/stdc++.h>

using namespace std;
int distance(pair<int, int> a, pair<int, int> b) {
  return abs(a.first-b.first) + abs(a.second - b.second);
}
int main() {
  // freopen("input.txt", "r", stdin);
  freopen("marathon.in", "r", stdin);
  freopen("marathon.out", "w", stdout);
  int n; cin >> n;
  vector<pair<int, int>> list(n);
  for (int i = 0; i < n; i++) {
    int a, b;
    cin >> a>> b;
    list[i].first = a;
    list[i].second = b;
  }
  pair<int, int> dist[n];
  int sum = 0;
  for (int i = 0; i < n-1; i++) {
    sum+=distance(list[i], list[i+1]);
  }
  for (int i = 1; i < n-1; i++) {
    dist[i].first = distance(list[i-1], list[i]);
    dist[i].second = distance(list[i], list[i+1]);
  }
  int ma = -1;
  for (int i= 1; i < n-1; i++) {
    ma = max(ma, dist[i].first+ dist[i].second- distance(list[i-1], list[i+1]));
    // cout<< i  << ": " << dist[i].first << " " << dist[i].second << " " << distance(list[i-1], list[i+1]) << endl;
  }
  sum-=ma;
  cout << sum;
}
