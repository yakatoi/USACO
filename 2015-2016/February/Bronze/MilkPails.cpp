#include <bits/stdc++.h>

using namespace std;

int main() {
  freopen("pails.in", "r", stdin);
  freopen("pails.out", "w", stdout);
  int x, y, m; cin >> x >> y >> m;
  int ans = m;
  for (int i = 0; i < m/x; i++) {
    ans = min(ans, (m-x*i)%y);
  }
  cout << m-ans;
}
