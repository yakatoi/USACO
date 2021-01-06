#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("square.in", "r", stdin);
  freopen("square.out", "w", stdout);
  int one[4];
  int two[4];
  cin >> one[0] >> one[1] >> one[2] >> one[3];
  cin >> two[0] >> two[1] >> two[2] >> two[3];
  int x1, y1, x2, y2;
  x1 = min(one[0], two[0]);
  y1 = min(one[1], two[1]);
  x2= max(one[2], two[2]);
  y2 = max(one[3], two[3]);
  int side = max(x2-x1, y2-y1);
  cout << side*side;
}
