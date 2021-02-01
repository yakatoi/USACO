#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  int t; cin >> t;
  while (t --> 0) {
    int n; cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) cin >> arr[i];
    int mi[n];
    mi[n-1] = arr[n-1];
    for (int i = n-2; i >= 0; i--) mi[i] = min(mi[i+1], arr[i]);
    int counter = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] > mi[i]) counter++;
    }
    cout << counter << endl;
  }
}
