#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> arr[100000];
int cow[100000];
int comp[100000];
int pain = 1;

void dfs(int node, int paint) {
  comp[node] = pain;
  for (int ele: arr[node]) {
    if (comp[ele] ==0 && cow[ele] == paint) {
      dfs(ele, paint);
    }
  }
}

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("milkvisits.in", "r", stdin);
  freopen("milkvisits.out", "w", stdout);
  cin >> n >> m;
  string str; cin >> str;
  for (int i = 0; i < n; i++) {
    if (str[i] == 'H') cow[i] = 1;
    else cow[i] = -1;
  }

  for (int i = 1; i < n; i++) {
    int a, b; cin >> a>> b;
    arr[--a].push_back(--b);
    arr[b].push_back(a);
  }
  for (int i = 0; i < n; i++) {
    if (comp[i] == 0) {
      dfs(i, cow[i]);
      pain++;
    }
  }
  // for (auto ele : cow) cout << ele << " ";
  // cout << endl;
  // for (auto ele : cow) cout << ele << endl;

  for (int i = 0; i < m; i++) {
    int a, b; string st; cin >> a>> b >> st;
    int type = st == "H"? 1 : -1;
    if (comp[--a] != comp[--b] || type==cow[a]) cout << 1;
    else cout << 0;
  }

}
