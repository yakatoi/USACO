#include <bits/stdc++.h>
using namespace std;

long long k, n, a, b;
bool check(long long x, long long y) {
  return x*a+y*b < k;
}

int main() {
  // freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  int t; cin >> t;
  while (t-->0) {
    cin >> k >> n>> a>>b;
    if (b*n >= k) {
      cout << -1;
    }
    else {
      // for (int i = 0; i <= n; i++) {
      //   cout << check(i, n-i) << endl;
      // }
      int lo = 0; int hi = n;
      while (lo != hi) {
        int mid = (lo+hi+1)/2;
        if (check(mid, n-mid)) lo = mid;
        else hi = mid-1;
      }
      cout << lo;
    }
    cout << "\n";
  }
}
