#include <bits/stdc++.h>
using namespace std;

bool simulate(int len, string str, int n) {
  int times = n-len+1;
  set<string> se;
  for (int i = 0; i < times; i++) {
    string temp = str.substr(i, len);
    se.insert(temp);
  }
  return se.size() == times;
}

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("whereami.in", "r", stdin);
  freopen("whereami.out", "w", stdout);
  int n; cin >> n;
  string str; cin >> str;
  int k = n;
  for (int i = 1; i < n; i++) {
    if (simulate(i, str, n)) {
      k = i;
      break;
    }
  }
  cout << k;
}
