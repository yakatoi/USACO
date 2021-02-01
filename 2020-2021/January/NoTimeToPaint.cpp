#include <bits/stdc++.h>
using namespace std;
int n, q;
string str;

int query(int a, int b) {

}
int main() {
  freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  cin >> n >> q;
  cin >> str;
  for (int i = 0; i < q; i++) {
    int a, b; cin >> a>> b;
    int ans = query(1, a-1) + query(b+1, n);
  }
}
