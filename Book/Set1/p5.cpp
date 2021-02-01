#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  int t; cin >> t;
  while (t --> 0) {
    long long A, B; cin >> A >> B;
    long long times = floor(log10(B+1));
    cout << times*A << endl;
  }
}
