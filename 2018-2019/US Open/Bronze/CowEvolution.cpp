#include <bits/stdc++.h>
using namespace std;
bool simulate(int x) {
  int mi = INT_MAX;
  for (int i = 1; i <= 50000; i++) {
    double k = i*1.0;
    int fn = floor(k+x/k);
    mi = min(fn, mi);
  }
  set<int> se;
  for (int i = 1; i <= 50000; i++) {
    double k = i*1.0;
    int fn = floor(k+x/k);
    if (fn==mi) se.insert(i);
  }
  return se.size()==1;
}
int main() {
  int counter = 0;
  for (int i = 1; i <= 1000; i++) {
    if (simulate(i)) counter++;
  }
  cout << counter << endl;
}
