#include <bits/stdc++.h>

using namespace std;
int n, m;
int jcount = 0;
int icount = 0;
int visited[50002];
vector<int> graph[50002];
void dfs(int node, int mark) {
  visited[node] = mark;
  if (mark==1) {
    jcount++;
  }
  else {
    icount++;
  }
  for (int e : graph[node]) {
    if (visited[e] == 0) {
      dfs(e, mark*-1);
    }
  }
}
int main() {
  // freopen("input.txt", "r", stdin);
  freopen("decorate.in", "r", stdin);
  freopen("decorate.out", "w", stdout);
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int a, b; cin >> a >> b;
    a--; b--;
    graph[a].push_back(b);
    graph[b].push_back(a);
  }
  for (int j = 0; j < n; j++) {
    if (visited[j] == 0) {
      int old[50002];
      int oldi = icount;
      int oldj = jcount;
      for (int i = 0; i < n; i++) {
        old[i] = visited[i];
      }
      dfs(j, 1);
      if ((icount-oldi)> (jcount-oldj)) {
        icount = oldi;
        jcount = oldj;
        for (int i = 0; i < n; i++) {
          visited[i] = old[i];
        }
        dfs(j, -1);
      }

    }
  }
  bool screwup = false;
  for (int i = 0; i < n; i++) {
    for (int node : graph[i]) {
      if (visited[node] == visited[i]) screwup = true;
    }
  }
  if (screwup) {
    cout << -1;
  }
  else {
    cout << jcount;
  }
}
