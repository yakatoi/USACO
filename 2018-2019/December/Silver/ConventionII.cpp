#include <bits/stdc++.h>
using namespace std;
struct Cow {
  int s, a, t;
  bool operator<(const Cow& b) const {
    return s < b.s;
  }
};
bool comp(Cow a, Cow b) {
  return a.a<b.a;
}
int main() {
  freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  int n; cin >> n;
  priority_queue<Cow> q;
  vector<Cow> vec;
  for (int i = n; i > 0; i--) {
    int arrival, time; cin >> arrival >> time;
    vec.push_back({i, arrival, time});
  }
  sort(vec.begin(), vec.end(), comp);
  for (auto ele : vec) {
    cout << ele.s << " " << ele.a << " " << ele.t << endl;
  }
  int ind = 0;
  int ans = 0;
  int time = 0;
  while (ind < n) {
    if (q.empty()) {
      if (time <= vec[ind].a) {
        time = vec[ind].a+vec[ind].t;
      }
      else {
        q.push(vec[ind]);
      }
      ind++;
    }
    while (q.is)
  }
}
