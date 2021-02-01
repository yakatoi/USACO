#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  int t;cin>>t;
  while (t --> 0) {
    int n, k; cin >> n >> k;
    bool isOdd[n];
    for (int i = 0; i < n; i++) {
      int inp; cin >> inp;
      isOdd[i] = inp%2;
    }
    int sum = 0;
    sum = accumulate(isOdd, isOdd+n, sum);
    if (sum%2 != k%2 || sum < k) {
      cout << "NO" << endl;
    }
    else {
      cout << "YES" << endl;
      set<int> se;
      for (int i = 0; i < n; i++) {
        if (isOdd[i]) se.insert(i);
      }
      int counter = 0;
      for (int ele : se) {
        if (counter == k-1) break;
        cout << ele+1 << " ";
        counter++;
      }
      cout << n << endl;
    }
  }
}
