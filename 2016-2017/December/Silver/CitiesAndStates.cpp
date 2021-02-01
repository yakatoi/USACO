#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("citystate.in", "r", stdin);
  freopen("citystate.out", "w", stdout);
  int n; cin >> n;
  map<string, set<string>> m;
  for (int i = 0; i < n; i++) {
    string one, two; cin >> one >> two;
    one = one.substr(0, 2);
    m[one].insert(two);
  }
  // for (auto ele : m) {
  //   cout << ele.first << ": ";
  //   for (auto element: ele.second) cout << element << " ";
  //   cout <<endl;
  // }
  int counter = 0;
  for (auto ele: m) {
    for (auto element : ele.second) {
      if (m[element].count(ele.first)) counter++;
    }
  }
  cout << counter/2 << endl;

}
