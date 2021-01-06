#include <bits/stdc++.h>

using namespace std;

int arr[1000];
int n;

int sim(int ind) {
  int sum = 0;
  for (int i = 1; i < n; i++) {
    sum+=(i*arr[(i+ind)%n]);
  }
  return sum;
}

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("cbarn.in", "r", stdin);
  freopen("cbarn.out", "w", stdout);
  cin >> n;
  for (int i = 0; i < n; i++) cin >>arr[i];
  int ans = INT_MAX;
  for (int i = 0; i < n; i++) {
    ans = min(ans, sim(i));
  }
  cout << ans;

}
