#include <bits/stdc++.h>

using namespace std;


int main() {
  // freopen("input.txt", "r", stdin);
  freopen("shuffle.in", "r", stdin);
  freopen("shuffle.out", "w", stdout);
  int n; cin >> n;
  int arr[n];
  for (int i= 0; i < n; i++) {
    int a; cin >> a;a--;
    arr[i] = a;
  }
  int ans[n];
  for (int i =0; i < n; i++) {
    int a = arr[arr[arr[i]]];
    ans[i] = a;
  }
  int sec[n];
  for (int i = 0; i < n; i++) {
    sec[ans[i]] = i;
  }
  int pri[n];
  for (int i = 0; i < n; i++) {
    int a; cin >> a;
    pri[sec[i]] = a;
  }
  for (int i = 0; i < n; i++) {
    cout << pri[i] << endl;
  }

}
/*
0: 0
1: 4
2: 1
3: 2
4: 3
*/
