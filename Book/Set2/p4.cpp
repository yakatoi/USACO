#include <bits/stdc++.h>
using namespace std;

int main() {
  freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  int n; cin >> n;
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  sort(arr, arr+n); // 1 2 10 12 15 17
  int ma = 1;
  // cout << (lower_bound(arr, arr+n, 4)-1)- arr<< endl;
  for (int i = 0; i < n-1; i++) {
    if (arr[i] + 5 < arr[n-1]) {
      int las = lower_bound(arr, arr+n, arr[i]+5)-1-arr;
      ma = max(ma, las-i+1);
      // cout << arr[i] << " " << arr[i] + 5 << " " <<las << endl;
    }
    else if (arr[i]+5 >= arr[n-1]) {
      ma = max(ma, n-i);
    }
  }
  cout << ma;
}
