#include <bits/stdc++.h>

using namespace std;

int main() {
  freopen("input.txt", "r", stdin);
  //freopen("template.in", "r", stdin);
  //freopen("template.out", "w", stdout);
  int n; cin >> n;
  vector<int> t;
  vector<int> d;
  for (int i = 0; i < n; i++) {
    string type; cin >> type;
    int inp; cin >> inp;
    if (type.compare("T")==0) {
      t.push_back(inp);
    }
    else {
      d.push_back(inp);
    }
  }
  int i, j;
  i =  j=0;
  sort(t.begin(), t.end());
  sort(d.begin(), d.end());
  double denom = 1;
  double frac = 1;
  double cur = 0;
  double dist = 0;
  
  while (i < t.size() && j < d.size()) {
    double a = t[i] - cur*1.0;
    double b = (d[j] - dist) / frac;
    if (a < b) {
      dist+=(a-cur)*frac;
      cur = a;
      i++;
    }
    else {
      dist+=(b-cur)*frac;
      cur = b;
      j++;
    }
    if (dist >= 1000) {
      cur-= (dist-1000)/frac;
      break;
    }
    denom++;
    frac = 1/denom;
  }
  while (j < d.size()) {
    double b = (d[j] - dist) / frac;
    if (dist >= 1000) {
      cur-= (dist-1000)/frac;
      break;
    }
    dist+=(b-cur)*frac;
    cur = b;
    j++;
    denom++;
    frac = 1/denom;
  }
  while (i < t.size()) {
    if (dist >= 1000) {
      cur-= (dist-1000)/frac;
      break;
    }
    double a = t[i] - cur*1.0;
    dist+=(a-cur)*frac;
    cur = a;
    i++;
    denom++;
    frac = 1/denom;
  }
  if (dist < 1000) {
    cur+=(1000-dist) * frac;
  }
  int ans = (int) (0.5 + cur);
  cout << ans;
}
