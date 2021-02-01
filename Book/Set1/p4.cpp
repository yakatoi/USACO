#include <bits/stdc++.h>
using namespace std;
bool comp(pair<int, int> a, pair<int, int> b) {
  return a.first+a.second < b.first+b.second;
}
string mult(string str, int times) {
  string ans = "";
  for (int i = 0; i < times; i++) {
    ans+=str;
  }
  return ans;
}
int main() {
  // freopen("input.txt", "r", stdin);
  // freopen("template.in", "r", stdin);
  // freopen("template.out", "w", stdout);
  int t; cin >> t;
  while (t--> 0) {
    int n; cin >> n;
    vector<pair<int, int>> vec;
    vec.push_back({0, 0});
    for (int i =0; i < n; i++) {
      int a, b; cin >> a>> b;
      vec.push_back({a, b});
    }
    sort(vec.begin(), vec.end(), comp);
    bool screwup = false;
    int prevx = -1;
    int prevy = -1;
    for (auto ele :vec) {
      if (ele.first < prevx || ele.second < prevy) screwup = true;
      prevx = ele.first;
      prevy = ele.second;
    }
    if (screwup) cout << "NO" <<endl;
    else {
      string ans = "";
      for (int i =1; i<= n; i++) {
        int xdif = vec[i].first - vec[i-1].first;
        int ydif = vec[i].second - vec[i-1].second;
        ans+=mult("R", xdif);
        ans+=mult("U", ydif);
      }
      cout << "YES" << endl << ans << endl;
    }
  }
}
