#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  int t; cin>>t;
  while (t-->0) {
    int n, s, k; cin >>n >> s >> k;
    set<int> se;
    for (int i = 0; i < k; i++) {
      int inp; cin >> inp;
      se.insert(inp);
    }
    if (se.count(s) == 0) cout << 0 << endl;
    else {
      int mult = 1;
      int pos = s;
      int ans = -1;
      while (true) {
        if (mult >0) {
          for (int i = pos; i <= pos+mult; i++) {
            if (se.count(i) ==0 && i>= 1 && i <= n) {
              ans = i;
              goto done;
            }
          }
        }
        else {
          for (int i = pos; i >= pos+mult; i--) {
            if (se.count(i) ==0 && i>= 1 && i <= n) {
              ans = i;
              goto done;
            }
          }
        }
        pos+=mult;
        mult*=-2;
      }
      done:
      cout << abs(ans-s) << endl;
    }
  }
}
