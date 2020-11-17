#include <bits/stdc++.h>

using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("reststops.in", "r", stdin);
  freopen("reststops.out", "w", stdout);
  long long l, n, rf, rb;
  cin >> l >> n >> rf >>rb;
  long long x, t;
  x= t=0;
  pair<long long, long long> arr[n];
  for (long long i = 0; i < n; i++) {
    long long a, b; cin >> a>>b;
    arr[i].first =b;
    arr[i].second=a;
  }
  long long count = 0;
  sort(arr, arr+n, greater<pair<long long, long long>>());
  for (auto ele : arr) {
    if (ele.second > x ) {
      t = (rf-rb)*(ele.second - x);
      count+=t*ele.first;
      x = ele.second;
    }

  }
  cout << count;
}
