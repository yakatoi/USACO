#include <bits/stdc++.h>
using namespace std;
int hol[100001];
int gue[100001];
int jer[100001];

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("bcount.in", "r", stdin);
  freopen("bcount.out", "w", stdout);
  int n, q; cin >> n >> q;
  for (int i = 1; i <= n; i++) {
    int inp; cin >> inp;
    if (inp==1) hol[i]++;
    if (inp==2) gue[i]++;
    if (inp ==3) jer[i]++;
    hol[i]+=hol[i-1];
    gue[i]+=gue[i-1];
    jer[i]+=jer[i-1];
  }
  for (int i = 0; i < q; i++) {
    int a, b; cin >> a >> b;
    cout << hol[b]- hol[a-1] << " " <<gue[b] - gue[a-1] << " "<<jer[b] - jer[a-1] << endl;
  }

}
