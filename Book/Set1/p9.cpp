#include <bits/stdc++.h>
using namespace std;
pair<int, int> findI(int arr[], int n, int ele) {
  int l = -1;
  int r = -1;
  for (int i = n-1; i >= 0; i--) {
    if (arr[i] == ele) {
      r = i;
      break;
    }
  }
  for (int i = 0; i < n; i++) {
    if (arr[i] == ele) {
      l= i;
      break;
    }
  }
  return {l, r};
}
int main() {
  // freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  int t; cin>>t;
  while (t-->0) {
    int n; cin >> n;
    int arr[n];
    set<int> se;
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      se.insert(arr[i]);
    }
    for (int i = 0; i < n-2; i++) {
      if (arr[i] == arr[i+2]) goto done;
    }
    for (int i = 0; i < n-3; i++) {
      if (arr[i] == arr[i+3] && arr[i+1] == arr[i+2]) goto done;
    }
    for (int ele : se) {
      pair<int, int> pa = findI(arr, n, ele);
      if (pa.second- pa.first > 1) goto done;
    }

    if (false) {
      done:
      cout << "YES" << endl;
    }
    else {
      cout << "NO" << endl;
    }
  }
}
