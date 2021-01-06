#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("word.in", "r", stdin);
  freopen("word.out", "w", stdout);
  int n, k; cin >> n >> k;
  string ans[n];
  string inp[n];
  for (int i =0 ; i < n; i++) cin >> inp[i];
  int ind = 0;
  int charcount = 0;
  for (auto word : inp) {
    if (word.length() + charcount <= k) {
      if (charcount ==0) {
        charcount = word.length();
        ans[ind] = word;
      }
      else {
        ans[ind] = (ans[ind] + " " + word);
        charcount+=word.length();
      }
    }
    else {
      ind++;
      charcount = word.length();
      ans[ind] = (word);
    }
  }
  for (auto ele : ans) {
    if (ele.length() ==0) break;
    cout << ele << endl;
  }
}
