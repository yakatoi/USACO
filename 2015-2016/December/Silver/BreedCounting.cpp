#include <bits/stdc++.h>

using namespace std;
int n;
void printArr(int arr[]) {
  for (int i = 0; i < n; i++) {
    cout << arr[i] << " ";
  }
  cout << endl;
}
int main() {
  freopen("input.txt", "r", stdin);
  //freopen("template.in", "r", stdin);
  //freopen("template.out", "w", stdout);
  int q; cin >> n >> q;
  int a[n+1];
  int b[n+1];
  int c[n+1];
  a[0] = 0;
  b[0] = 0;
  c[0] = 0;
  for (int i = 1; i <= n; i++) {
    int inp; cin >> inp;
    a[i] = a[i-1] + inp==1?1:0;
    b[i] = b[i-1] + inp==2?1:0;
    c[i] = c[i-1] + inp==3?1:0;
  }
  printArr(a);
  printArr(b);
  printArr(c);
  for (int i = 0; i < q; i++) {
    int x, y; cin >> x >> y;
    cout << (a[y]-a[x-1]) << " " << (b[y]-b[x-1]) << " "  << (c[y]-c[x-1]) << endl;
  }
}
