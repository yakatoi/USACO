#include <bits/stdc++.h>

using namespace std;

int main() {
  //freopen("input.txt", "r", stdin);
  freopen("lemonade.in", "r", stdin);
  freopen("lemonade.out", "w", stdout);
  int n; cin >> n;
  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  sort(arr, arr+n, greater<int>());
  int count = 0;
  int counter = 0;
  for (int ele : arr) {
    if (count <= ele) {
      counter++;
    }
    count++;
  }
  cout << counter;

}
