#include <bits/stdc++.h>
using namespace std;

int n, q;
vector<pair<int, int>> graph[5000];
int bfs(int node, int k) {
  bool visited[n];
  queue<int> q;
  q.push(node);
  visited[node] = true;
  int counter = 0;
  while (!q.empty()) {
    int v = q.front();
    q.pop();
    for (auto ele : graph[v]) {
      if (ele.second >= k && !visited[ele.first]) {
        q.push(ele.first);
        counter++;
      }
      visited[ele.first] = true;
    }
  }
  return counter;
}
int main() {
  // freopen("input.txt", "r", stdin);
  freopen("mootube.in", "r", stdin);
  freopen("mootube.out", "w", stdout);
  cin >> n >> q;
  for (int i = 1; i < n; i++) {
    int a, b, c; cin >> a>> b >> c;
    a--;b--;
    graph[a].push_back({b, c});
    graph[b].push_back({a, c});
  }
  // for (int i =0 ; i < n; i++) {
  //   cout << i << ": ";
  //   for (auto ele : graph[i]) cout << "(" << ele.first << ", " << ele.second << "), ";
  //   cout << endl;
  // }
  for (int i = 0; i < q; i++) {
    int k, v; cin >> k >> v;
    cout << bfs(--v, k) << endl;
  }
}
