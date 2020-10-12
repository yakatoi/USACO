#include <iostream>
#include <cstdio>

using namespace std;

int main() {
  freopen("promote.in", "r", stdin);
  freopen("promote.out", "w", stdout);

  int b1, b2, s1, s2, g1, g2, p1, p2;
  cin >> b1 >> b2>> s1 >> s2 >> g1 >> g2 >>p1 >>p2;
  int c = p2-p1;
  int b = g2+c-g1;
  int a = b+s2-s1;
  cout << a << "\n";
  cout << b << "\n";
  cout << c;
}
