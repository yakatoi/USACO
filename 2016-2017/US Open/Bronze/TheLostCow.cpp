#include <bits/stdc++.h>

using namespace std;

bool isBet(int a, int b, int c) {
  return (c <= a && c >= b) || (c >= a && c <= b);
}

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("lostcow.in", "r", stdin);
  freopen("lostcow.out", "w", stdout);
  int x, y; cin >> x >> y;
  int dist = 0;
  int mult = 1;
  int mov = x;
  while (true) {
    if (isBet(mov, x+mult, y)) {
      dist+=abs(mov-y);
      break;
    }
    else {
      dist+=abs(mov-(x+mult));
      mov = x+mult;
      mult*=-2;
    }
  }
  cout << dist;

}
