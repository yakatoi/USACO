#include <bits/stdc++.h>

using namespace std;
int maxQuery(int h[], int p[], int s[], int a, int b) {
  int a1 = h[b]-h[a-1];
  int a2 = p[b]-p[a-1];
  int a3 = s[b]-s[a-1];
  int ans = max(a1, a2);
  ans = max(ans, a3);
  return ans;
}
int main() {
  // freopen("input.txt", "r", stdin);
  freopen("hps.in", "r", stdin);
  freopen("hps.out", "w", stdout);
  int n; cin >> n;
  int h[n+1];
  int p[n+1];
  int s[n+1];
  h[0] = 0;
  p[0] = 0;
  s[0] = 0;
  for (int i = 1; i <= n; i++) {
    string inp; cin >> inp;
    h[i] = h[i-1];
    p[i] = p[i-1];
    s[i] = s[i-1];
    if (inp.compare("H")==0) h[i]++;
    if (inp.compare("P")==0) p[i]++;
    if (inp.compare("S")==0) s[i]++;
  }
  int ans = max(h[n], p[n]);
  ans = max(ans, s[n]);
  ans = max(ans, maxQuery(h, p, s, 1, n));
  for (int i = 1; i <= n; i++) {
    int x = maxQuery(h, p, s, 1, i);
    int y = maxQuery(h, p, s, min(i+1, n), n);
    //cout << i << " " << x << " " << y << endl;
    ans =max(x+y, ans);
  }
  cout << ans;
}
