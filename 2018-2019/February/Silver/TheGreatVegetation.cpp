#include <bits/stdc++.h>
using namespace std;
struct edge {
  string type;
  int node;
};
int n, m;
vector<edge> graph[100000];
int mark[100000];
int counter = 0;

void dfs(int node, int paint) {
  mark[node] = paint;
  for (auto ele : graph[node]) {
    if (mark[ele.node]==0) {
      if (ele.type == "S") dfs(ele.node, paint);
      else dfs(ele.node, paint*-1);
    }
  }
}

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("revegetate.in", "r", stdin);
  freopen("revegetate.out", "w", stdout);
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    string str; int a, b; cin >> str >> a >> b;
    --a;--b;
    graph[a].push_back((edge) {str, b});
    graph[b].push_back((edge) {str, a});
  }
  // for (int i = 0; i < n; i++) {
  //   cout << i << ": ";
  //   for (auto ele : graph[i]) cout << "(" << ele.type << ", " << ele.node << "), ";
  //   cout << endl;
  // }
  for (int i = 0; i < n; i++) {
    if (mark[i] ==0) {
      dfs(i, 1);
      counter++;
    }
  }
  cout << 1;
  while (counter --> 0) cout << 0;

}
