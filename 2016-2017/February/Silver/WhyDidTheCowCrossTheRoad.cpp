#include <bits/stdc++.h>
using namespace std;
bool comp(pair<int, int> a, pair<int, int> b) {
  if (a.second == b.second) return a.first < b.first;
  return a.second < b.second;
}
int main() {
  // freopen("input.txt", "r", stdin);
  freopen("helpcross.in", "r", stdin);
  freopen("helpcross.out", "w", stdout);
  int c, n; cin >> c >> n;
  int chickens[c];
  pair<int, int> cows[n];
  for (int i =0; i < c; i++) cin >> chickens[i];
  for (int i = 0; i < n; i++) {
    int a, b; cin >> a >> b;
    cows[i] = {a, b};
  }
  sort(chickens, chickens+c);
  sort(cows, cows+n, comp);
  // for (auto ele: chickens) cout << ele << endl;
  // cout << endl;
  // for (auto ele: cows)   cout << ele.first << " " << ele.second << endl;
  int counter = 0;
  int i = 0;
  int j = 0;
  while (i < c && j < n) {
    if (cows[j].first > chickens[i]) i++;
    else if (cows[j].second < chickens[i]) j++;
    else {
      counter++; i++; j++;
    }
  }
  cout << counter;
}
