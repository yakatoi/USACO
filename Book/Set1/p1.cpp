#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  int t; cin>>t;
  while (t-->0) {
    int n; cin >> n;
    int maxs[n];
    set<int> se;
    for (int i = 1; i <= n; i++) se.insert(i);
    for (int i = 0; i < n; i++) cin >> maxs[i];
    int guess[n] = {0};
    guess[0] = maxs[0];
    se.erase(guess[0]);
    for (int i = 1; i< n; i++) {
      if (maxs[i]!=maxs[i-1]) {
        guess[i] = maxs[i];
        se.erase(guess[i]);
      }
    }
    for (int i = 0; i < n; i++) {
      if (guess[i] == 0) {
        int low = *se.begin();
        se.erase(low);
        guess[i] = low;
      }
    }
    bool check = true;
    int ma = guess[0];
    for (int i = 0; i < n; i++) {
      ma = max(guess[i], ma);
      if (ma!= maxs[i]) check = false;
    }
    if (!check) {
      cout << -1 << endl;
    }
    else {
      for (int i = 0; i < n-1; i++) {
        cout << guess[i] << " ";
      }
      cout << guess[n-1] << endl;
    }
  }
}
