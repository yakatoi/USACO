#include <bits/stdc++.h>
using namespace std;
int n, m, c;
int arr[100000];
bool simulate(int x) {
  int buses = 0;
  int fillup = 0;
  int end = -1;
  for (int i = 0; i < n; i++) {
    if (end < arr[i] || fillup == c) {
      buses++;
      fillup = 0;
      end = arr[i] + x;
    }
    fillup++;
    if (buses > m) break;
  }
  return buses <= m;
}
int main() {
  // freopen("input.txt", "r", stdin);
  freopen("convention.in", "r", stdin);
  freopen("convention.out", "w", stdout);
  cin >> n >> m >> c;
  for (int i = 0; i < n; i++) cin >> arr[i];
  sort(arr, arr+n);
  // for (int i = 1; i <= 10; i++) {
  //   cout << i << ": " << simulate(i) << endl;
  // }
  // for (int i = 0; i < n; i++) cout << arr[i] << " ";
  int a = 0; int b = INT_MAX;
  while (a!=b) {
    int mid = (a+b)/2;
    if (simulate(mid)) {
      b = mid;
    }
    else {
      a = mid+1;
    }
  }
  cout << a;
}
