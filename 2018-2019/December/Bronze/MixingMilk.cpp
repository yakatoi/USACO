#include <bits/stdc++.h>

using namespace std;

int c[3];
int m[3];

void pour(int st, int en) {
  if (m[st] + m[en] <= c[en]) {
    m[en]+=m[st];
    m[st] = 0;
  }
  else {
    m[st] = m[st] + m[en] - c[en];
    m[en] = c[en];
  }
}

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("mixmilk.in", "r", stdin);
  freopen("mixmilk.out", "w", stdout);
  cin >> c[0] >> m[0];
  cin >> c[1] >> m[1];
  cin >> c[2] >> m[2];
  // cout << c[0] << " " << c[1] << " " << c[2] << endl;
  // cout << m[0] << " " << m[1] << " " << m[2] << endl;
  for (int i = 0; i < 33; i++) {
    pour(0, 1);
    pour(1, 2);
    pour(2, 0);
  }
  pour(0, 1);
  cout << m[0] << endl;
  cout << m[1] << endl;
  cout << m[2] << endl;
}
