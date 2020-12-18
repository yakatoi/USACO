#include <bits/stdc++.h>

using namespace std;
int n, m, k, a, b, counter;
void dfs(int node, int mark[], int arr[]) {
  mark[node] = counter;
  if (mark[arr[node]] == 0) {
    dfs(arr[node], mark, arr);
  }
}
int main() {
  // freopen("input.txt", "r", stdin);
  freopen("swap.in", "r", stdin);
  freopen("swap.out", "w", stdout);
  cin >> n >> m >> k;
  counter = 1;
  int arr[n];
  int mark[n];
  for (int i = 0; i < n; i++) {
    arr[i] = i;
    mark[i] = 0;
  }
  for (int i = 0; i < m; i++) {
    cin >> a>> b;
    a--;b--;
    for (int i = a; i <= (a+b)/2; i++) {
      int temp = arr[i];
      arr[i] = arr[a+b-i];
      arr[a+b-i] = temp;
    }
  }
  for (int i = 0; i < n; i++) {
    if (mark[i] == 0) {
      dfs(i, mark, arr);
      counter++;
    }
  }
  unordered_map<int, int> map;
  for (int ele: mark) {
    map[ele] = map[ele] + 1;
  }
  for (int i = 0; i < n; i++) {
    if (map[mark[i]] == 1) {
      cout << i+1 << endl;
    }
    else {
      int rep = k % map[mark[i]];
      int bef = i;
      for (int j = 0; j < rep; j++) {
        bef = arr[bef];
      }
      cout << bef+1 << endl;
    }
  }
}
