#include <bits/stdc++.h>
using namespace std;
vector<pair<string, string>> vec;
bool simulate(string a[], int n) {
  map<string, int> map;
  for (int i = 0; i < n; i++) {
    map[a[i]] = i;
  }
  for (pair<string, string> p : vec) {
    if (abs(map[p.first]-map[p.second]) > 1) return false;
  }
  return true;
}

// Function to find the permutations
void perm(string a[], int n) {
  sort(a, a + n);
  do {
    if (simulate(a, n)) return;
  }
  while (next_permutation(a, a + n));
}

int main() {
  // freopen("input.txt", "r", stdin);
  freopen("lineup.in", "r", stdin);
  freopen("lineup.out", "w", stdout);
  int n; cin >> n;
  for (int i= 0; i < n; i++) {
    string one; cin >> one;
    string two; cin >> two >> two >> two >> two >> two;
    vec.push_back({one, two});
  }
  string a[] = {"Beatrice" ,"Sue", "Belinda", "Bessie", "Betsy", "Blue", "Bella", "Buttercup"};
  perm(a, n);
  for (string ele : a) cout << ele << endl;
}
