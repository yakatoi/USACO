#include <bits/stdc++.h>
using namespace std;

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0); cout.tie(0);
  long long n, k;
  cin >> n>>k;
  set<long long> se;
  for (long long i = 0; i < n; i++) {
    long long inp; cin >> inp;
    se.insert(inp/12+1);
  }
  se.insert(0);
  vector<long long> diff;
  long long prev = -1;
  for (auto ele : se) {
    if (prev >= 0 && ele-prev-1 > 0) diff.push_back(ele-prev-1);
    prev = ele;
  }
  sort(diff.begin(), diff.end());
  long long count = se.size()-1;
  for (long long i = 0; i < diff.size() + 1 - k; i++) {
    count+=diff[i];
  }
  cout << count*12;
}
