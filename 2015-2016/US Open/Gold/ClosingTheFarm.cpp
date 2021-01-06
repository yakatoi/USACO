#include <bits/stdc++.h>
using namespace std;

int parent[500000];
void initialize(int n) {for (int i = 0; i < n; i++) parent[i] = i;}
int find(int x){if(x == parent[x]) return x; return parent[x] = find(parent[x]);}
void unite(int a, int b) { int c = find(a); int d = find(b); if(c != d) parent[d] = c; }
int main() {
  freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  int n, m; cin >> n>> m;
  vector<int> arr[n];
  for (int i = 0; i < m; i++) {
    int a, b; cin >> a >> b; a--; b--;
    arr[a].push_back(b);
    arr[b].push_back(a);
  }
  vector<int> inp;
  for (int i = 0; i < n; i++) {
    int a; cin>> a;
    inp.push_back(a);
  }
  for (int i =0 ; i < n; i++) {
    cout << i << ": ";
    for (auto ele : arr[i]) cout << ele << ", ";
    cout << endl;
  }
  reverse(inp.begin(), inp.end());
  for (auto ele : inp) cout<< ele << endl;
  vector<string> ans;
  set<int> total;
  for (auto ele: inp) {
    total.insert(ele);
    for (int el : arr[ele]) {
      if (total.count(el) == 1) {
        unite(el, ele);
      }
    }
    set<int> diff;
    for (int el : total) diff.insert(find(el));
    if (diff.size() == 1) ans.push_back("YES");
    else ans.push_back("NO");
  }
  reverse(ans.begin(), ans.end());
  for (auto ele : ans) {
    cout << ele << endl;
  }
}
