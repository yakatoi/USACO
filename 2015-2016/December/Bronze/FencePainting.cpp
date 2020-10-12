#include <iostream>
#include <cstdio>
using namespace std;

int main() {
  freopen("paint.in", "r", stdin);
  freopen("paint.out", "w", stdout);
  int a, b, c, d;
  cin  >> a >> b >> c >> d;
  int counter = 0;
  for (int i = 1; i <= 100; i++) {
    if ((i-1 >= a && i <= b) || (i-1 >= c && i <= d)) {
      counter++;
    }
  }

  cout << counter;
}
