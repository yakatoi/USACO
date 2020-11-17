#include <bits/stdc++.h>

using namespace std;
int n;
int main() {
  //freopen("input.txt", "r", stdin);
  freopen("highcard.in", "r", stdin);
  freopen("highcard.out", "w", stdout);
  cin >> n;
  vector<int> vec;
  for (int i = 1; i <= 2*n; i++) vec.push_back(0);
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    vec[temp] = 1;
  }
  vector<int> bessie;
  vector<int> elsie;
  for (int i = 1; i <= 2*n; i++) {
    if (vec[i]==0) bessie.push_back(i);
    if (vec[i]==1) elsie.push_back(i);
  }
  sort(bessie.begin(), bessie.end());
  sort(elsie.begin(), elsie.end());
  int i = 0;
  int j = 0;
  int counter = 0;
  while (i < n && j < n) {
  //cout <<i << " " <<j << "\n";
    if (bessie[i] > elsie[j]) {
      counter++;
      i++;
      j++;
    }
    else {
      i++;
    }
  }
  cout << counter;
  return 0;
}
