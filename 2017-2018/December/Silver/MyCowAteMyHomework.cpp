#include <bits/stdc++.h>
using namespace std;

int main() {
  freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  int n; cin >> n;
  int arr[n];
  for (int i = n-1; i >= 0; i--) {
    cin >> arr[n];
  }
  int pre[n];
  pre[0] = arr[0];
  for (int i = 1; i < n; i++) {
    pre[i] = pre[i-1] + arr[i];
  }
  int mini[n];
  mini[0] = arr[0];
  for (int i = 1; i < n; i++) {
    mini[i] = min(mini[i-1], arr[i]);
  }
  int index = -1;
  int ans = -1;
  for (int i = 1; i < n-1; i++) {
    int total = pre[n-1];
    int num = n-i-1;
    total-=pre[i];
  }
}
