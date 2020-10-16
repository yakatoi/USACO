#include <iostream>
#include <cstdio>
using namespace std;

int main() {
  freopen("teleport.in", "r", stdin);
  freopen("teleport.out", "w", stdout);

  int a, b, x, y;
  cin >> a >> b >> x >> y;
  int ans = abs(a-b);
  ans = min(ans, abs(a -x)  + abs(y - b));
  ans = min(ans, abs(a -y)  + abs(x - b));
  cout << ans;

}
