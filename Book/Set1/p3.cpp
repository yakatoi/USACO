#include <bits/stdc++.h>
using namespace std;
long long n, k;
bool check(long long x) {
  return x*(x+1)/2-(n-x) <= k;
}
int main() {
  // freopen("input.txt", "r", stdin);
  cin >> n>> k;
  long long a = 0; long long b = n;
  while (a!=b) {
    long long mid = (a+b+1)/2;
    if (check(mid)) a = mid;
    else b = mid-1;
  }
  cout << n-b;
}
