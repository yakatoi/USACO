#include <bits/stdc++.h>
using namespace std;

vector<int> graph[200];
int counter = 0;
struct Cow {int x, y, p;};

void dfs(int node, bool visited[]){
  visited[node] = true;
  for(int next : graph[node]){
    if(!visited[next]){
      dfs(next, visited);
    }
  }
}
int main() {
  // freopen("input.txt", "r", stdin);
  freopen("moocast.in", "r", stdin);
  freopen("moocast.out", "w", stdout);
  int n; cin >> n;
  Cow arr[n];
  for (int i = 0; i < n; i++) {
    int a, b, c; cin >> a >> b >> c;
    arr[i] = {a, b, c};
  }
  for (int i = 0; i < n; i++) {
    for (int j = i +1; j < n; j++) {
      int dist2 = (arr[i].x-arr[j].x)*(arr[i].x-arr[j].x) + (arr[i].y-arr[j].y)*(arr[i].y-arr[j].y);
      if (arr[i].p*arr[i].p >= dist2) graph[i].push_back(j);
      if (arr[j].p*arr[j].p >= dist2) graph[j].push_back(i);
    }
  }
  // for (int i =0 ; i < n; i++) {
  //   cout << i << ": ";
  //   for (auto ele : graph[i]) cout << ele << ", ";
  //   cout << endl;
  // }
  int ans = -1;
  for (int i = 0; i < n; i++) {
    bool visited[n];
    for (int j = 0; j < n; j++) visited[j] = false;
    dfs(i, visited);
    int counter = 0;
    for (bool ele : visited) {
      if (ele) counter++;
    }
    ans = max(ans, counter);
  }
  cout << ans;

}
