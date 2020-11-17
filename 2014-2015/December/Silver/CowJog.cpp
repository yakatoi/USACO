#include <bits/stdc++.h>

using namespace std;
struct Cow {
  long long pos, sped, end;
};
bool compareCows(Cow a, Cow b) {
  return a.pos >b.pos;
}
int main() {
  //freopen("input.txt", "r", stdin);
  freopen("cowjog.in", "r", stdin);
  freopen("cowjog.out", "w", stdout);
  int n;
  long long t;
  cin >> n >> t;
  Cow arr[n];
  for (int i = 0; i < n; i++) {
    long long a, b; cin >> a>> b;
    arr[i] = {(long long) a, (long long) b, (long long) t*b+a};
  }
  sort(arr, arr+n, compareCows);
  long long mi = LLONG_MAX;
  int counter = 0;
  for (Cow c: arr) {
    //cout << c.pos << " " << c.sped << " " << c.end << endl;
    //cout << mi <<endl;
    if (c.end < mi) counter++;
    mi = min(mi, c.end);
  }
  //cout << endl;
  //cout << n << " " << t << endl;
  cout << counter;
}
