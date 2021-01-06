#include <bits/stdc++.h>
using namespace std;

int ans = -1;


void simulate(int ind, int n, pair<int, int> arr[]) {
  int sum = 0;
  int field[1001] = {};
  for (int i = 0; i < n; i++) {
    if (i!=ind) {
      for (int j = arr[i].first; j <= arr[i].second; j++) field[j]++;

    }
  }
  for (int ele : field) {
    if (ele > 0) sum++;
  }
  ans = max(sum, ans);
}


int main() {
  // freopen("input.txt", "r", stdin);
  freopen("lifeguards.in", "r", stdin);
  freopen("lifeguards.out", "w", stdout);
  int n; cin >> n;
  pair<int, int> arr[n];
  for (int i = 0; i < n; i++) {
    int a, b; cin >> a>> b;
    arr[i] = {a, --b};
  }
  for (int i = 0; i < n; i++) {
    simulate(i, n, arr);
  }
  cout << ans;

}
