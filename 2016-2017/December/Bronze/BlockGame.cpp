#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("blocks.in", "r", stdin);
  freopen("blocks.out", "w", stdout);
  int n; cin >> n;
  int arr[26] = {};
  for (int i = 0; i < n; i++) {
    string a, b; cin >> a>> b;
    multiset<char> se1;
    multiset<char> se2;
    set<char> es;
    for (char c: a) {se1.insert(c); es.insert(c);}
    for (char c: b) {se2.insert(c); es.insert(c);}
    for (auto ele : es) {
      arr[int(ele)-97]+=max(se1.count(ele), se2.count(ele));
    }
  }
  for (int ele : arr) cout << ele << endl;
}
