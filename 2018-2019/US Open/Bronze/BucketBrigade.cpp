#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("buckets.in", "r", stdin);
  freopen("buckets.out", "w", stdout);
  pair<int, int> b;
  pair<int, int> r;
  pair<int, int> l;
  for (int i = 0; i < 10; i++) {
    string str; cin >> str;
    for (int j = 0; j < 10; j++) {
      if (str[j] == 'B') b = {i, j};
      if (str[j] == 'R') r = {i, j};
      if (str[j] == 'L') l = {i, j};
    }
  }
  bool hor = b.first == r.first && r.first == l.first;
  bool vert = b.second == r.second && r.second == l.second;
  if (hor) {
    if (abs(b.second-r.second) == 1 && abs(l.second-r.second) == 1) cout << 3;
    else cout << abs(b.second - l.second) + 1;
  }
  else if (vert) {
    if (abs(b.first-r.first) == 1 && abs(l.first-r.first) == 1) cout << 3;
    else cout << abs(b.first - l.first) + 1;
  }
  else {
    cout << abs(b.first-l.first) + abs(b.second-l.second) - 1;
  }

}
