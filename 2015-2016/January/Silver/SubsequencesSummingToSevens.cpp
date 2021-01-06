#include <bits/stdc++.h>
using namespace std;

int main() {
  freopen("input.txt", "r", stdin);
  // freopen("div7.in", "r", stdin);
  // freopen("div7.out", "w", stdout);
  int n; cin >> n;
  int large = 0;
  int arr[n+1];
  for (int i = 1; i <= n; i++) {
    cin >> arr[i];
  }
  for (int i = 1; i <= n; i++) {
    arr[i]+=arr[i-1];
    arr[i]%=7;
  }
  int startA[7];
  int en[7];
  for (int i = 0; i < 7; i++) {
    startA[i] = n+1;
    en[i] = -1;
  }
  for (int i = 1; i <= n; i++) {
    startA[arr[i]] = min(startA[arr[i]], i);
    en[arr[i]] = max(startA[arr[i]], i);
  }
  cout << "startA";
  for (int i = 0; i < 7; i++) cout << startA[i] << " ";
  cout  << endl;
  cout << "en";
  for (int i = 0; i < 7; i++) cout << en[i] << " ";
  cout  << endl;
  for (int i = 0; i < 7; i++) {
    large = max(en[i] - startA[i], large);
  }
  cout << large;
}
