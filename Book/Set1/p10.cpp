#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  long long t; cin >> t;
  while (t --> 0) {
    long long n, k; cin >> n>> k;
    if (n%2!=k%2) {
      done:
      cout << "NO" <<endl;
    }
    else {
      long long sum = k*k;
      if (sum > n ||(n-sum)%2!=0) goto done;
      cout << "YES" <<endl;
    }
  }
}
